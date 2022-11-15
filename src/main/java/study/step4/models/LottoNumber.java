package study.step4.models;

import study.step4.exception.LottoNumberOutOfRangeException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Set<LottoNumber> lottoNumbers = new HashSet<>();

    private int number;

    public LottoNumber(int number) {
        validateNumberInRange(number);
        this.number = number;
    }

    public LottoNumber(String bonusBall) {
        this(Integer.parseInt(bonusBall));
    }

    public int getNumber() {
        return number;
    }

    public int compare(LottoNumber number) {
        return this.number - number.getNumber();
    }

    private void validateNumberInRange(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new LottoNumberOutOfRangeException(
                    String.format("로또 숫자는 %d이상 %d이하의 숫자만 가능합니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public static Set<LottoNumber> getLottoNumbers() {
        if (lottoNumbers.isEmpty()) {
            makeLottoNumbers();
        }
        return new HashSet<>(lottoNumbers);
    }

    private static void makeLottoNumbers() {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
