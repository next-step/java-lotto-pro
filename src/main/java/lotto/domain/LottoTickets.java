package lotto.domain;

import lotto.constants.ErrorMessage;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY_LOTTO);
        }
        return new LottoTickets(lottoTickets);
    }

    public LottoWinningRanks match(LottoTicket winningNumbers, LottoNumber bonusBall) {
        LottoWinningRanks lottoWinningRanks = LottoWinningRanks.create();
        lottoTickets.forEach(lottoTicket -> {
            lottoWinningRanks.addWinningRank(lottoTicket.rank(winningNumbers, bonusBall));
        });
        return lottoWinningRanks;
    }

    public void addAll(LottoTickets addTickets) {
        this.lottoTickets.addAll(addTickets.lottoTickets);
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public boolean contains(LottoTicket lottoTicket) {
        return lottoTickets.contains(lottoTicket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LottoTicket lottoTicket : this.lottoTickets) {
            sb.append(lottoTicket.toString()).append("\n");
        }
        return sb.toString();
    }
}
