package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class BonusNumber {

    private final int bounsNumber;

    public BonusNumber(int bonusNumber) {
        validateLottoNumber(bonusNumber);
        this.bounsNumber = bonusNumber;
    }

    private static void validateLottoNumber(int bonusNumber) {
        if (bonusNumber < LottoRoleConst.LOW_NUMBER || bonusNumber > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

    public int getBounsNumber() {
        return bounsNumber;
    }

    public boolean matchBonusNumber(List<Integer> numberList) {
        return numberList.contains(bounsNumber);
    }
}
