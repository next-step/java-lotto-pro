package lotto;

import static java.lang.Integer.parseInt;
import static java.util.stream.IntStream.rangeClosed;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final Set<LottoNumber> ALL_LOTTO_NUMBERS = allLottoNumbers();
    private static final int START_NUM = 1;
    private static final int LAST_NUM = 45;
    private final int number;

    private LottoNumber(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public static LottoNumber valueOf(final int number) {
        return ALL_LOTTO_NUMBERS.stream()
                .filter(lottoNumber -> lottoNumber.number == number)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static LottoNumber valueOf(final String numberString) {
        return valueOf(parseInt(numberString));
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(final int number) {
        if (number > LAST_NUM || number < START_NUM) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
        }
    }

    private static Set<LottoNumber> allLottoNumbers() {
        return rangeClosed(LottoNumber.START_NUM, LottoNumber.LAST_NUM)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        final LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public int compareTo(final LottoNumber o) {
        return this.number - o.number;
    }
}
