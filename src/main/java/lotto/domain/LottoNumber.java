package lotto.domain;

import lotto.view.OutputView;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        isValidRange(number);
        this.number = number;
    }

    public LottoNumber(String stringNumber) {
        try {
            int number = Integer.parseInt(stringNumber);
            isValidRange(number);
            this.number = number;
        } catch (NumberFormatException e) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    private void isValidRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            OutputView.printErrorMessage();
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.number, o.number);
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
}
