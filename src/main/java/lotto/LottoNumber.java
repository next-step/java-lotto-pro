package lotto;

import java.util.Objects;

public class LottoNumber implements Number {

    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private final int number;

    public LottoNumber(String number) {
        validNumber(number);
        this.number = Integer.parseInt(number);
    }

    @Override
    public int getIntNumber() {
        return number;
    }

    @Override
    public void validNumber(String number) {
        validNumberFormat(number);
        validRange(number);
    }

    private void validNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("로또 번호는 숫자여야 합니다. 입력 값:" + number);
        }
    }

    private void validRange(String number) {
        int parseInt = Integer.parseInt(number);
        if (parseInt < LOTTO_MIN_NUMBER || LOTTO_MAX_NUMBER < parseInt) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다. 입력 값:" + number);
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
}
