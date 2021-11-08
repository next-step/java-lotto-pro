package lotto.domain;

import java.util.List;

public class LottoTicket {

    private List<Lotto> lottoTicket;

    public LottoTicket(List<Lotto> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Lotto> getLottoTicket() {
        return lottoTicket;
    }

    public void compareWinningNumbers(LottoNumbers lottoWinningNumbers) {
        lottoTicket.forEach(lotto -> lotto.compareWinningNumbers(lottoWinningNumbers));
    }

    public double getRateOfReturn(LottoPurchase lottoPurchase) {
        return (double) getTotalPrizeMoney() / lottoPurchase.getPurchaseAmount();
    }

    public int getTotalPrizeMoney() {
        return lottoTicket.stream()
                .map(lotto -> lotto.getLottoRank().getPrizeMoney())
                .reduce(0, Integer::sum);
    }

    public int getTotalRankCount(LottoRank rank) {
        return Math.toIntExact(lottoTicket.stream()
                .filter(lotto -> lotto.getLottoRank().equals(rank))
                .count());
    }

}
