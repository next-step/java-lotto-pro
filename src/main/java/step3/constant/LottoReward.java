package step3.constant;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoReward {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5_000),
    FOUR(50_000),
    FIVE(1_500_000),
    SIX(2_000_000_000);


    private final int reward;

    private LottoReward(int reward) {
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public static final Map<Integer, String> numberToLottoReward =
        Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(LottoReward::ordinal,LottoReward::name)));


}
