package step3.domain.statistics;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum WinningLottoType {

    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private static final Map<Integer, WinningLottoType> TYPES_BY_MATCH_COUNT =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(WinningLottoType::getMatchCount, Function.identity())));

    private final int matchCount;
    private final int winningAmount;

    WinningLottoType(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static WinningLottoType findByMatchCount(int matchCount) {
        if (matchCount < 3) {
            return NOTHING;
        }
        return TYPES_BY_MATCH_COUNT.get(matchCount);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }
}
