package lotto.model;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        this.validateNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }
}
