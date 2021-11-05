package lotto.domain;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum Winnings {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50000),
    FORTH(3, 5000);

    private final int correspondCount;
    private final long amount;

    Winnings(final int correspondCount, final long amount) {
        this.correspondCount = correspondCount;
        this.amount = amount;
    }

    private Integer getCorrespondCount() {
        return this.correspondCount;
    }

    private Long getAmount() {
        return this.amount;
    }

    private static final Map<Integer, Winnings> intToEnum = Stream.of(values())
            .collect(toMap(e -> e.getCorrespondCount(), Function.identity()));

    public static long getAmount(int correspondCount) {
        return Optional.ofNullable(intToEnum.get(correspondCount))
                .map(Winnings::getAmount)
                .orElse(0L);

    }
}
