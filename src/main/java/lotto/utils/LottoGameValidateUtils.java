package lotto.utils;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class LottoGameValidateUtils {

    private LottoGameValidateUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static void validateMoney(int money) {
        validateLackMoney(money);
        validateOverMoney(money);
        validateUnitMoney(money);
    }

    private static void validateLackMoney(int money) {
        if (money < LottoRoleConst.LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY);
        }
    }

    private static void validateOverMoney(int money) {
        if (money >= LottoRoleConst.LOTTO_MAX_PURCHASE_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.OVER_MONEY);
        }
    }

    private static void validateUnitMoney(int money) {
        if (money % LottoRoleConst.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_UNIT_MONEY);
        }
    }

    public static void validateWinningNumberList(List<Integer> winningNumberList) {
        validateNumberSize(winningNumberList);
        validateDuplication(winningNumberList);
        for (int winningNumber : winningNumberList) {
            validateLottoNumber(winningNumber);
        }
    }

    private static void validateNumberSize(List<Integer> winningNumberList) {
        if (winningNumberList.size() != LottoRoleConst.LOTTO_NUMBER_LIST_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NON_SIX_NUMBERS);
        }
    }

    private static void validateDuplication(List<Integer> winningNumberList) {
        HashSet<Integer> deleteDuplicationNumber = new HashSet<>(winningNumberList);
        if(winningNumberList.size() != deleteDuplicationNumber.size()){
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION);
        }
    }

    private static void validateLottoNumber(int winningNumber) {
        if (winningNumber < LottoRoleConst.LOW_NUMBER || winningNumber > LottoRoleConst.MAX_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.NOT_LOTTO_NUMBER);
        }
    }

}
