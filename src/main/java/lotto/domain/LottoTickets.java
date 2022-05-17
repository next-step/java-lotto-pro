package lotto.domain;

import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public WinningResult match(LottoTicket lottoNumbers) {
        WinningResult winningResult = new WinningResult();
        lottoTickets.forEach(lottoTicket -> {
            winningResult.addWinningRank(lottoTicket.rank(lottoNumbers));
        });
        return winningResult;
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
