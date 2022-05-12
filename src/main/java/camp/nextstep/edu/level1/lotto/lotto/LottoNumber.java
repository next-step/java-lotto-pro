package camp.nextstep.edu.level1.lotto.lotto;

public class LottoNumber {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;

    private final int value;

    public LottoNumber(int value) {
        checkValidLottoNumber(value);
        this.value = value;
    }

    private void checkValidLottoNumber(int value) {
        if (value < LOTTO_START_NUMBER || value > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 만 허용됩니다.");
        }
    }

    public boolean hasSameValue(LottoNumber value) {
        return this.value == value.value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
