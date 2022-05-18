package lotto.domain;

import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets(){
        return this.lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public WinningResult match(LottoTicket lottoNumbers, LottoNumber bonusNumber) {
        WinningResult winningResult = new WinningResult();
        lottoTickets.forEach(lottoTicket -> {
            winningResult.addWinningRank(lottoTicket.rank(lottoNumbers, bonusNumber));
        });
        return winningResult;
    }
}
