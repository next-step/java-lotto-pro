package camp.nextstep.edu.level1.lotto.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult(List<LottoNumbers> purchaseLotto, LottoNumbers winnerLottoNumbers) {
        purchaseLotto.forEach(lotto -> {
            addLottoRankCountIfRankIsNotNull(LottoRank.findLottoRank(lotto, winnerLottoNumbers));
        });
    }

    public Money winningAmount() {
        Money amount = new Money(0);

        for (Map.Entry<LottoRank, Integer> lottoRankIntegerEntry : result.entrySet()) {
            Money rankPrice = lottoRankIntegerEntry.getKey().rankPrice();
            Integer count = lottoRankIntegerEntry.getValue();
            Money rankTotalPrice = rankPrice.multiply(count);

            amount = amount.add(rankTotalPrice);
        }

        return amount;
    }

    private void addLottoRankCountIfRankIsNotNull(LottoRank rank) {
        if (rank != null) {
            result.putIfAbsent(rank, 0);
            result.replace(rank, result.get(rank) + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        result.forEach((rank, count) -> sb.append(rank.rankDescription())
                .append(" (")
                .append(rank.rankPrice())
                .append(")- ")
                .append(count)
                .append("개")
                .append("\n"));

        return sb.toString();
    }
}
