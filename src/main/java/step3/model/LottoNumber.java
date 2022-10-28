package step3.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {


    public static final int LOTTO_MIN_VALUE = 1;
    public static final int LOTTO_MAX_VALUE = 45;
    private static final String OUT_OF_NUMBER_MESSAGE = "번호는 1에서 45사이만 허용합니다";
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream
                .rangeClosed(LOTTO_MIN_VALUE, LOTTO_MAX_VALUE)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    private static void validateNumber(int number) {
        if (number >= LOTTO_MIN_VALUE && number <= LOTTO_MAX_VALUE) {
            return;
        }
        throw new IllegalArgumentException(OUT_OF_NUMBER_MESSAGE);

    }

    public static LottoNumber valueOf(int number) {
        validateNumber(number);
        return LOTTO_NUMBERS.get(number - 1);
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
