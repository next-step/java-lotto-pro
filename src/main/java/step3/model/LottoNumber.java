package step3.model;

import step3.constant.ErrorMessageConstant;
import step3.constant.LottoConstant;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;

    public LottoNumber(String text) {
        int lottoNumber = convertNumber(text);
        checkOutOfSize(lottoNumber);
        this.number = lottoNumber;
    }

    public LottoNumber(int number) {
        checkOutOfSize(number);
        this.number = number;
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessageConstant.NOT_NUMBER);
        }
        return result;
    }

    private void checkOutOfSize(int number) {
        if (number < LottoConstant.LOTTO_MIN_NUM || number > LottoConstant.LOTTO_MAX_NUM) {
            throw new RuntimeException(ErrorMessageConstant.OUT_OF_SIZE_NUMBER);
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
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
