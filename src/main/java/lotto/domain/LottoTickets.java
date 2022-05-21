package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private static final String ERROR_MSG_NOT_MACHED_QUANTITY = "입력한 수량과 로또 번호의 수가 일치하지 않습니다.";

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(List<LottoTicket> lottoTickets, int ticketQuantity) {
        validateQuantity(lottoTickets, ticketQuantity);
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return this.lottoTickets;
    }

    public WinningResult match(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        lottoTickets.forEach(lottoTicket -> {
            winningResult.addWinningRank(lottoTicket.rank(lottoNumbers, bonusNumber));
        });
        return winningResult;
    }

    public LottoTickets add(LottoTickets lottoTickets) {
        List<LottoTicket> lottoTicketList = Stream.concat(this.lottoTickets.stream(), lottoTickets.getLottoTickets().stream())
                .collect(Collectors.toList());
        return new LottoTickets(lottoTicketList);
    }

    public int size() {
        return this.lottoTickets.size();
    }

    private void validateQuantity(List<LottoTicket> lottoTickets, int ticketQuantity) {
        if (lottoTickets.size() != ticketQuantity) {
            throw new IllegalArgumentException(ERROR_MSG_NOT_MACHED_QUANTITY);
        }
    }
}
