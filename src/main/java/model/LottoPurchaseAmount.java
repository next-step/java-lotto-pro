package model;

import Utils.PatternUtils;
import exception.LottoAmountUnitException;
import exception.NotPositiveNumberException;

public class LottoPurchaseAmount {
    private static final int AMOUNT_PER_LOTTO = 1000;
    private static final String AMOUNT_UNIT_ERROR_MESSSAGE = "1000 단위로 입력해주세요.";
    private static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "양수만 입력 가능합니다.";
    private int amount;

    public LottoPurchaseAmount(String amount) {
        validCheck(amount);

        this.amount = Integer.parseInt(amount);
    }

    public int getQuantityPerAmountLotto() {
        return amount / AMOUNT_PER_LOTTO;
    }

    private void validCheck(String amount) {
        if (!PatternUtils.isPositiveNumber(amount)) {
            throw new NotPositiveNumberException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }

        if (!isRightAmountUnit(amount)) {
            throw new LottoAmountUnitException(AMOUNT_UNIT_ERROR_MESSSAGE);
        }
    }

    private boolean isRightAmountUnit(String amount) {
        return Integer.parseInt(amount) % AMOUNT_PER_LOTTO ==0;
    }

    @Override
    public boolean equals(Object obj) {
        LottoPurchaseAmount target = (LottoPurchaseAmount) obj;
        return this.amount == target.amount;
    }
}
