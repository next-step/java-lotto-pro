package lotto.model;

import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class WinningLotto {

    private final List<Integer> numberList;

    public WinningLotto(List<Integer> numberList) {
        validateWinningNumberList(numberList);
        this.numberList = numberList;
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
