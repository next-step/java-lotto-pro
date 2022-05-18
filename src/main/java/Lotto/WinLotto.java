package Lotto;

import Lotto.error.ErrorMessage;

public class WinLotto {
    private int bonusNumber;
    private Lotto lotto;

    public WinLotto() {
        this.lotto = new Lotto();
    }

    public WinLotto(String customNumbers, int bonusNumber) {
        this.lotto = new Lotto(customNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void generateBonus(String inputBonus) {
        int bonus = 0;
        try {
            bonus = Integer.parseInt(inputBonus);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.BonusNumberInputWrong.getErrorMsg());
        }
        bonusValidate(bonus);
        bonusNumber = bonus;
    }

    public void bonusValidate(int bonus) {
        if(RangeNumbers.MIN_NUMBER > bonus || RangeNumbers.MAX_NUMBER < bonus) {
            throw new IllegalArgumentException(ErrorMessage.BonusNumberOutOfRange.getErrorMsg());
        }

        if(lotto.getNumbers().contains(bonus))
            throw new IllegalArgumentException(ErrorMessage.BonusNumberDuplicate.getErrorMsg());
    }

}
