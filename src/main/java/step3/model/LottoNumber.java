package step3.model;

import java.util.Objects;

import static step3.constant.ErrorMessage.ONLY_NUMBER_PAST_LOTTO_INPUT;

public class LottoNumber implements Comparable<LottoNumber> {

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ONLY_NUMBER_PAST_LOTTO_INPUT);
        }
    }

    public int value() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber number1 = (LottoNumber) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber number) {
        if (this.number > number.number) {
            return 1;
        }
        if (this.number < number.number) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "" + number;
    }
}
