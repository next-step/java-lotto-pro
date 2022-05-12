package lotto.lotto;

import java.util.Objects;

class LottoNumber implements Comparable<LottoNumber> {

    static final int MIN_VALUE = 1;
    static final int MAX_VALUE = 45;

    private final int value;

    protected LottoNumber(String value) {
        this(parse(value));
    }

    protected LottoNumber(int value) {
        this.value = validated(value);
    }

    public static LottoNumber of(String value) {
        return new LottoNumber(value);
    }

    public static LottoNumber of(int value) {
        return new LottoNumber(value);
    }

    private static int parse(String value) {
        if (value == null || value.isEmpty()) {
            throw new LottoNumberFormatException(value);
        }
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            throw new LottoNumberFormatException(value);
        }
    }

    private static int validated(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new LottoNumberOutOfBoundsException(value);
        }
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) other;
        return value == lottoNumber.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(this.value, other.value);
    }
}
