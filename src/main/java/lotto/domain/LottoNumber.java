package lotto.domain;

public class LottoNumber {
    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAXIMUM_LOTTO_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validLottoNumber(number);
        this.number = number;
    }

    private static void validLottoNumber(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 숫자입니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}