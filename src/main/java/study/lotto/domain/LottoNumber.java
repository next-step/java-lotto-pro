package study.lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 45;

    private int value;

    public LottoNumber(String stringValue) {
        this(Integer.parseInt(stringValue));
    }

    public LottoNumber(int value) {
        if (validate(value)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자만 허용합니다.");
        }
        this.value = value;
    }

    public LottoNumber(LottoNumber lottoNumber) {
        this.value = lottoNumber.value;
    }

    public int get() {
        return value;
    }

    private boolean validate(int lottoNumber) {
        return lottoNumber < MINIMUM_NUMBER || lottoNumber > MAXIMUM_NUMBER;
    }

    @Override
    public String
    toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
