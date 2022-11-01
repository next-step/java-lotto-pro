package step3.model;

import java.util.List;

public class WinningLotto {

    private static final String DUPLICATE_BONUS_NUMBER_MESSAGE = "보너스번호는 고유한 번호만 허용합니다";
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_MESSAGE);
        }
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public boolean isMatchBonusNumber(List<LottoNumber> numbers) {
        return numbers.contains(bonusNumber);
    }
}
