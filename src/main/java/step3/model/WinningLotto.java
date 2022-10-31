package step3.model;

public class WinningLotto {

    private static final String DUPLICATE_NUMBER_MESSAGE = "고유한 번호만 허용합니다";

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto,LottoNumber bonusNumber){
        validateBonusNumber(lotto,bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto,LottoNumber bonusNumber){
        if(lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}
