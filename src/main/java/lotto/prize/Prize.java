package lotto.prize;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Prize {
    FIRST(6, BigDecimal.valueOf(2000000000)),
    SECOND(5, BigDecimal.valueOf(1500000)),
    THIRD(4, BigDecimal.valueOf(50000)),
    FOURTH(3, BigDecimal.valueOf(5000));

    private final int matchCount;
    private final BigDecimal prizeMoney;
    public static final Map<Integer, Prize> matchCounts =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Prize::getMatchCount, Function.identity())));

    Prize(int matchCount, BigDecimal prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public BigDecimal getPrizeMoney() {
        return prizeMoney;
    }

}
