package study.lotto.automatic.domain;

import java.util.Objects;

public class LottoNumber {
    static final int MINIMUM_NUMBER = 1;
    static final int MAXIMUM_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (validate(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45사이의 숫자만 허용합니다.");
        }
        this.lottoNumber = lottoNumber;
    }

    private boolean validate(int lottoNumber) {
        return lottoNumber < MINIMUM_NUMBER || lottoNumber > MAXIMUM_NUMBER;
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "lottoNumber=" + lottoNumber +
                '}';
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
