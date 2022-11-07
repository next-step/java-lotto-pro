package lotto.domain;

import lotto.util.InputValidator;

public class LottoAmount {
    private final int totalLottoAmount;
    private final int userWrittenLottoAmount;

    private LottoAmount(int totalLottoAmount, int userWrittenLottoAmount) {
        InputValidator.validateUserWrittenLottoAmount(totalLottoAmount, userWrittenLottoAmount);
        this.totalLottoAmount = totalLottoAmount;
        this.userWrittenLottoAmount = userWrittenLottoAmount;
    }

    public static LottoAmount of(int totalLottoAmount, int userWrittenLottoAmount) {
        return new LottoAmount(totalLottoAmount, userWrittenLottoAmount);
    }

    public int getUserWrittenLottoAmount() {
        return userWrittenLottoAmount;
    }

    public int getAutoLottoAmount() {
        return totalLottoAmount - userWrittenLottoAmount;
    }
}
