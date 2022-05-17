package lotto_auto.model;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusBall;
    public WinningLotto(LottoNumbers numbers, LottoNumber bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
        checkDuplicateNumber();
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }

    private void checkDuplicateNumber() {
        if (this.getLottoNumbers().getLottoNumberSet().contains(bonusBall)) {
            throw new IllegalArgumentException(LottoNumbers.EXIST_DUPLICATE_VALUE);
        }
    }
}
