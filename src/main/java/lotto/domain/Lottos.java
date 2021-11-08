package lotto.domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void compareWinningNumbers(LottoNumbers lottoWinningNumbers) {
        lottos.forEach(lotto -> lotto.compareWinningNumbers(lottoWinningNumbers));
    }

    public double getRateOfReturn(LottoPurchase lottoPurchase) {
        return (double) getTotalPrizeMoney() / lottoPurchase.getPurchaseAmount();
    }

    public int getTotalPrizeMoney() {
        return lottos.stream()
                .map(lotto -> lotto.getLottoRank().getPrizeMoney())
                .reduce(0, Integer::sum);
    }

    public int getTotalRankCount(LottoRank rank) {
        return Math.toIntExact(lottos.stream()
                .filter(lotto -> lotto.getLottoRank().equals(rank))
                .count());
    }

}
