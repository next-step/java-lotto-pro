package lotto.application.service;

import lotto.domain.*;
import lotto.infrastructure.generator.NumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private final NumberGenerator lottoNumberGenerator;

    public LottoService(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets purchaseLottoTicketsByAuto(final String payAmount) {
        PayAmount lottoPayAmount = new PayAmount(payAmount);

        LottoCount lottoCount = lottoPayAmount.calculateLottoCount();

        return createLottoTickets(lottoCount);
    }

    public LottoResult getRankCount(final List<Integer> winningLottoNumbers, final Integer bonusBall, final LottoTickets purchasedLottoTickets) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningLottoNumbers, bonusBall);

        return purchasedLottoTickets.compareWinningLottoTicket(winningLottoTicket);
    }

    private LottoTickets createLottoTickets(LottoCount lottoCount) {
        List<LottoTicket> lottoTickets = Stream.generate(lottoNumberGenerator::generate)
                .map(LottoTicket::new)
                .limit(lottoCount.getLottoCount())
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }
}
