package lotto.model;

import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class BonusNumber {

    private final int number;

    public BonusNumber(int number) {
        validateLottoNumber(number);
        this.number = number;
    }

    private static void validateLottoNumber(int bonusNumber) {
        if (bonusNumber < LottoRoleConst.LOW_NUMBER || bonusNumber > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean matchBonusNumber(List<Integer> numberList) {
        return numberList.contains(number);
    }
}
