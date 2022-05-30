package lotto.application.service;

import lotto.application.command.LottoCommand;
import lotto.domain.*;
import lotto.infrastructure.generator.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoService {

    private final NumberGenerator lottoNumberGenerator;

    public LottoService(NumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoTickets purchaseLottoTicketsByAuto(final LottoCommand.Purchase command) {
        final LottoCount autoLottoCount = calculateAutoLottoCount(command);

        return getLottoTickets(command, autoLottoCount);
    }

    private LottoCount calculateAutoLottoCount(final LottoCommand.Purchase command) {
        final PayAmount lottoPayAmount = new PayAmount(command.getPayAmount());
        final LottoCount manualLottoCount = new LottoCount(command.getManualLottoCount());

        return lottoPayAmount.calculateAutoLottoCount(manualLottoCount);
    }

    private LottoTickets getLottoTickets(final LottoCommand.Purchase command, final LottoCount autoLottoCount) {
        final List<List<Integer>> manualLottoNumbers = Collections.unmodifiableList(command.getManualLottoNumbers());
        final List<List<Integer>> autoLottoNumbers = Collections.unmodifiableList(createAutoLottoNumbers(autoLottoCount));

        final List<LottoTicket> totalLottoTickets = Stream.concat(manualLottoNumbers.stream(), autoLottoNumbers.stream())
                .map(LottoTicket::new)
                .collect(Collectors.toList());

        return new LottoTickets(totalLottoTickets);
    }

    private List<List<Integer>> createAutoLottoNumbers(final LottoCount lottoCount) {
        return Stream.generate(lottoNumberGenerator::generate)
                .limit(lottoCount.getLottoCount())
                .collect(Collectors.toList());
    }

    public LottoResult getRankCount(final List<Integer> winningLottoNumbers, final Integer bonusBall, final LottoTickets purchasedLottoTickets) {
        final WinningLottoTicket winningLottoTicket = new WinningLottoTicket(winningLottoNumbers, bonusBall);

        return purchasedLottoTickets.compareWinningLottoTicket(winningLottoTicket);
    }
}
