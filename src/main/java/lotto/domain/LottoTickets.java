package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY_LOTTO);
        }
        this.lottoTickets = lottoTickets;
    }

    public LottoWinningRanks match(LottoTicket winningNumbers) {
        LottoWinningRanks lottoWinningRanks = new LottoWinningRanks();
        lottoTickets.forEach(lottoTicket -> {
            lottoWinningRanks.addWinningRank(lottoTicket.rank(winningNumbers));
        });
        return lottoWinningRanks;
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
