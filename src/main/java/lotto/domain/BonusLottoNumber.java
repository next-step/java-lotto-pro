package lotto.domain;

import lotto.exception.LottoException;

public class BonusLottoNumber extends LottoNumber {

    protected static final String BONUS_NUMBER_ERROR = "보너스 볼은 당첨 번호와 같을 수 없습니다.";

    protected BonusLottoNumber(int bonusNumber) {
        super(bonusNumber);
    }

    public BonusLottoNumber(int bonusNumber, int[] numbers) {
        super(bonusNumber);
        validateBonusNumber(bonusNumber, numbers);
    }

    private void validateBonusNumber(int bonusNumber, int[] numbers) {
        for (int number : numbers) {
            validateDuplicate(bonusNumber, number);
        }
    }

    private void validateDuplicate(int bonusNumber, int number) {
        if (bonusNumber == number) {
            throw new LottoException(BONUS_NUMBER_ERROR);
        }
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
