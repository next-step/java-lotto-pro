package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LottoReward {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    private final int matchCount;
    private final int rewardMoney;

    LottoReward(int matchCount, int rewardMoney) {
        this.matchCount = matchCount;
        this.rewardMoney = rewardMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getRewardMoney() {
        return rewardMoney;
    }

    public static boolean isWinning(int matchCount) {
        List<Integer> matchCounts = Arrays.stream(LottoReward.values())
                .map(lottoReward -> lottoReward.getMatchCount())
                .collect(Collectors.toList());
        return matchCounts.contains(matchCount);
    }

    public static LottoReward getLottoReward(int matchCount) {
        Optional<LottoReward> lottoReward = Arrays.stream(LottoReward.values())
                .filter(l -> l.getMatchCount() == matchCount)
                .findAny();
        return lottoReward.orElse(null);
    }
}
