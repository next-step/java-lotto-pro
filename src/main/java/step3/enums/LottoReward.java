package step3.enums;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoReward {
    ZERO(0, 0),
    ONE(0, 1),
    TWO(0, 2),
    THREE(5_000, 3),
    FOUR(50_000, 4),
    FIVE(1_500_000, 5),
    SIX(2_000_000_000, 6);

    private final int reward;
    private final int matchCount;

    public int getMatchCount() {
        return matchCount;
    }

    LottoReward(int reward, int matchCount) {
        this.reward = reward;
        this.matchCount = matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static final Map<Integer, String> numberToLottoReward =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoReward::getMatchCount, LottoReward::name)));

}
