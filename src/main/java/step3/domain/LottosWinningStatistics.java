package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottosWinningStatistics {
    private static final int THREE_MATCHED_COUNT = 3;
    private static final int FOUR_MATCHED_COUNT = 4;
    private static final int FIVE_MATCHED_COUNT = 5;
    private static final int SIX_MATCHED_COUNT = 6;
    private static final int NOT_MATCHED_REWARD = 0;
    private static final int THREE_MATCHED_REWARD = 5000;
    private static final int FOUR_MATCHED_REWARD = 50000;
    private static final int FIVE_MATCHED_REWARD = 1500000;
    private static final int SIX_MATCHED_REWARD = 2000000000;

    private final List<Integer> matches;
    private final int price;
    private final int totalReward;
    private final double yield;

    public LottosWinningStatistics(final Lottos lottos, final LottoWinningNumbers winningNumbers) {
        this.matches = lottos.match(winningNumbers);
        this.price = lottos.size() * Lotto.LOTTO_FIXED_PRICE;
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
        if(match == THREE_MATCHED_COUNT){
            return THREE_MATCHED_REWARD;
        }
        if(match == FOUR_MATCHED_COUNT){
            return FOUR_MATCHED_REWARD;
        }
        if(match == FIVE_MATCHED_COUNT){
            return FIVE_MATCHED_REWARD;
        }
        if(match == SIX_MATCHED_COUNT){
            return SIX_MATCHED_REWARD;
        }
        return NOT_MATCHED_REWARD;
    }

    public String[] toStringArray() {
        final List<String> stringList = new ArrayList<>();
        final int threeMatchedCount = getMatchedCount(THREE_MATCHED_COUNT);
        final int fourMatchedCount = getMatchedCount(FOUR_MATCHED_COUNT);
        final int fiveMatchedCount = getMatchedCount(FIVE_MATCHED_COUNT);
        final int sixMatchedCount = getMatchedCount(SIX_MATCHED_COUNT);

        stringList.add("3개 일치 (5000원)- " + threeMatchedCount + "개");
        stringList.add("4개 일치 (50000원)- " + fourMatchedCount + "개");
        stringList.add("5개 일치 (1500000원)- " + fiveMatchedCount + "개");
        stringList.add("6개 일치 (2000000000원)- " + sixMatchedCount + "개");
        stringList.add("총 수익률은 " +  String.format("%.2f", yield) + "입니다.");

        return stringList.toArray(new String[0]);
    }

    private int getMatchedCount(final int matchedCount) {
        return (int) matches.stream()
                .filter(match -> match == matchedCount)
                .count();
    }
}
