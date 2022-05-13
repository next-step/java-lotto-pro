package camp.nextstep.edu.level1.lotto.lotto;

public class LottoNumber {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        checkValidLottoNumber(number);
        this.number = number;
    }

    private void checkValidLottoNumber(int number) {
        if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 만 허용됩니다.");
        }
    }

    public boolean hasSameValue(LottoNumber number) {
        return this.number == number.number;
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
