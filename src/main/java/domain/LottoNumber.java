package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber {

    public static final int LOTTO_START_INCLUSIVE = 1;
    public static final int LOTTO_END_INCLUSIVE = 45;

    private static final List<LottoNumber> CACHE = IntStream.rangeClosed(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        try {
            return CACHE.get(number - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("유효하지 않은 로또 번호입니다.");
        }
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
