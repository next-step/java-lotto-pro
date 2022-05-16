package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class LottoNumber implements Comparable<LottoNumber> {

    public static final int LOTTO_START_INCLUSIVE = 1;
    public static final int LOTTO_END_INCLUSIVE = 45;

    private static final List<LottoNumber> CACHE = IntStream.rangeClosed(LOTTO_START_INCLUSIVE, LOTTO_END_INCLUSIVE)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toUnmodifiableList());
    private static final List<LottoNumber> LOTTO_NUMBERS_POOL = new ArrayList<>(CACHE);

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

    public static Set<LottoNumber> randomNumbers(int size) {
        Collections.shuffle(LOTTO_NUMBERS_POOL);
        return LOTTO_NUMBERS_POOL.stream()
                        .limit(size)
                        .collect(Collectors.toUnmodifiableSet());
    }

    public int value() {
        return this.number;
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

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
