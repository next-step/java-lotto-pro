package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber from(String lottoNumber) {
        return new LottoNumber(Integer.parseInt(lottoNumber));
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > 45) {
            throw new IllegalArgumentException("로또 숫자는 1 이상 45 이하 입니다.");
        }
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

    @Override
    public int compareTo(LottoNumber o) {
        if (lottoNumber > o.lottoNumber) {
            return 1;
        }
        if (lottoNumber < o.lottoNumber) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
