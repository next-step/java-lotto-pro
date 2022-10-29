package domain;

import java.util.Arrays;

public enum LottoWinning {
    FIRST_PRIZE(NumberMatchRange.of(6, 6), 2000000000f),
    SECOND_PRIZE(NumberMatchRange.of(5, 5), 1500000f),
    THIRD_PRIZE(NumberMatchRange.of(4, 4), 50000f),
    FOURTH_PRIZE(NumberMatchRange.of(3, 3), 5000f),
    NONE(NumberMatchRange.of(0, 2), 0f);

    private final NumberMatchRange numberMatchRange;
    private final float prize;

    LottoWinning(NumberMatchRange numberMatchRange, float prize) {
        this.numberMatchRange = numberMatchRange;
        this.prize = prize;
    }

    public static LottoWinning of(int numberMatchSize) {
        return Arrays.stream(LottoWinning.values())
            .filter(l -> l.numberMatchRange.contains(numberMatchSize))
            .findFirst()
            .orElse(NONE);
    }

    public float getPrize() {
        return prize;
    }

    static class NumberMatchRange {
        private final int start;
        private final int end;

        public static NumberMatchRange of(int start, int end) {
            return new NumberMatchRange(start, end);
        }

        public boolean contains(int value) {
            return value >= start && value <= end;
        }

        private NumberMatchRange(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
