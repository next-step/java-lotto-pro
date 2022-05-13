package lotto.domain;

public class LottoNumber {
    private int number;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public LottoNumber(int number) {
        valid(number);
        this.number = number;
    }

    private void valid(int number) {
        if (isNotNumberRange(number)) {
            throw new IllegalArgumentException(
                    "로또의 숫자는" + MIN_NUMBER + "~" + MAX_NUMBER + "까지만 허용합니다.");
        }
    }

    private boolean isNotNumberRange(int number) {
        return number < MIN_NUMBER || number > MAX_NUMBER;
    }
}
