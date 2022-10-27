package step3.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static step3.constant.WinningPrice.price;

public class LottoResult {

    Map<Integer, Integer> sameCounts = new HashMap<>();

    public void addResult(int sameNumberCount) {
        if (!isPresentCount(sameNumberCount)) {
            sameCounts.put(sameNumberCount, 0);
        }
        int count = sameCounts.get(sameNumberCount);
        count++;
        sameCounts.put(sameNumberCount, count);
    }

    private boolean isPresentCount(int sameNumberCount) {
        return sameCounts.get(sameNumberCount) != null;
    }

    public String createSameCountMessage(int sameNumber) {
        return new StringBuilder(String.valueOf(sameNumber))
                .append("개 일치 ")
                .append("(")
                .append(winningPrice(sameNumber))
                .append("원")
                .append(")- ")
                .append(Optional.ofNullable(sameCounts.get(sameNumber)).orElse(0))
                .append("개").toString();
    }

    private int winningPrice(int sameNumber) {
        return price.get(sameNumber);
    }

    public int sumWinningPrice() {
        int winningPrice = 0;
        for (Integer sameCount : sameCounts.keySet()) {
            winningPrice += Optional.ofNullable(price.get(sameCount)).orElse(0) * sameCounts.get(sameCount);
        }
        return winningPrice;
    }

    public String createLottoStatisticsMessage(LottoGenerator lottoGenerator) {
        int totalWinningPrice = sumWinningPrice();
        return new StringBuilder("총 수익률은 ")
                .append(lottoGenerator.calculatorResult(totalWinningPrice))
                .append("입니다.")
                .toString();
    }

}
