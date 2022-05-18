package lotto_auto.model;

public class WinningLotto {
    private final LottoNumber bonusBall;
    private final Lotto lotto;
    public WinningLotto(Lotto lotto, LottoNumber bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
        checkDuplicateNumber();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private void checkDuplicateNumber() {
        if (lotto.isContain(bonusBall)) {
            throw new IllegalArgumentException(LottoNumbers.EXIST_DUPLICATE_VALUE);
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public boolean isContain(LottoNumber number) {
        return lotto.isContain(number);
    }
}
