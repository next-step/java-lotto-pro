package study.lotto;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final Integer number;

    public LottoNumber() {
        this.number = Randoms.pickNumberInRange(1, 45);
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(String number) {
        this(Integer.parseInt(number.trim()));
    }

    private void validate(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("%d ~ %d 사이의 숫자만 생성할 수 있습니다.", MIN_NUMBER, MAX_NUMBER));
        }
    }

    public Integer getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.getNumber();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumber that = (LottoNumber) o;

        return number.equals(that.number);
    }
}
