package step3.model;

import step2.ErrorMessageConstant;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    int number;

    public LottoNumber(String text) {
        this.number = convertNumber(text);
        checkOutOfSize();
    }

    public LottoNumber(int number) {
        this.number = number;
        checkOutOfSize();
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new RuntimeException(ErrorMessageConstant.NOT_NUMBER);
        }
        return result;
    }

    private void checkOutOfSize() {
        if (this.number < MIN_NUM || this.number > MAX_NUM) {
            throw new RuntimeException(ErrorMessageConstant.NEGATIVE_NUMBER);
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
