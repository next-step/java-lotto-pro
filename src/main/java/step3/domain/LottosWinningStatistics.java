package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.constants.Matched;

public class LottosWinningStatistics {
    private final List<Integer> matches;
    private final int price;
    private final int totalReward;
    private final double yield;

    public LottosWinningStatistics(final Lottos lottos, final LottoWinningNumbers winningNumbers) {
        this.matches = lottos.match(winningNumbers);
        this.price = lottos.getLottosCount() * Lotto.LOTTO_FIXED_PRICE;
        this.totalReward = calculateTotalReward(matches);
        this.yield = totalReward / (double) price;
    }

    private int calculateTotalReward(final List<Integer> matches) {
        int totalReward = 0;
        for (final Integer match : matches) {
            totalReward += calculateReward(match);
        }
        return totalReward;
    }

    private int calculateReward(final Integer match) {
        return Matched.getByCount(match)
                .getReward();
    }

    public String[] toStringArray() {
        final List<String> stringList = new ArrayList<>();
        final int threeMatchedCount = getMatchedCount(Matched.THREE_MATCHED.getCount());
        final int fourMatchedCount = getMatchedCount(Matched.FOUR_MATCHED.getCount());
        final int fiveMatchedCount = getMatchedCount(Matched.FIVE_MATCHED.getCount());
        final int sixMatchedCount = getMatchedCount(Matched.SIX_MATCHED.getCount());

        stringList.add("3개 일치 (5000원)- " + threeMatchedCount + "개");
        stringList.add("4개 일치 (50000원)- " + fourMatchedCount + "개");
        stringList.add("5개 일치 (1500000원)- " + fiveMatchedCount + "개");
        stringList.add("6개 일치 (2000000000원)- " + sixMatchedCount + "개");
        stringList.add("총 수익률은 " + String.format("%.2f", yield) + "입니다.");

        return stringList.toArray(new String[0]);
    }

    private int getMatchedCount(final int matchedCount) {
        return (int) matches.stream()
                .filter(match -> match == matchedCount)
                .count();
    }
}
