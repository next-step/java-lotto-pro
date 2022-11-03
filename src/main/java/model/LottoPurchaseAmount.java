package model;

import Utils.PatternUtils;
import exception.BuyableLottoNumberSizeException;
import exception.LottoAmountUnitException;
import exception.NotPositiveNumberException;

public class LottoPurchaseAmount {
    private static final int ZERO = 0;
    private static final int AMOUNT_PER_LOTTO = 1000;
    private static final double FLOOR_STAND_DELIMETER = 100;

    private static final String AMOUNT_UNIT_ERROR_MESSSAGE = "1000 단위로 입력해주세요.";
    public static final String NOT_POSITIVE_NUMBER_ERROR_MESSAGE = "양수만 입력 가능합니다.";
    public static final String NOT_BUYABLE_ZERO_LOTTO_SIZE_ERROR_MESSAGE = "0장은 구매할수 없습니다. 0을 넘어서는 양수를 입력하세요.";
    public static final String BUYABLE_LOTTO_NUMBER_SIZE_EXCESS_ERROR_MESSAGE = "구입 가능한 로또수를 넘어섰습니다.";

    private int amount;

    public LottoPurchaseAmount(String amount) {
        validCheckPositiveNumber(amount);
        validCheckRightAmountUnit(amount);

        this.amount = Integer.parseInt(amount);
    }

    public int getQuantityPerAmountLotto() {
        return amount / AMOUNT_PER_LOTTO;
    }

    public int getTotalPrice() {
        return this.amount;
    }

    private void validCheckPositiveNumber(String amount) {
        if (!PatternUtils.isPositiveNumber(amount)) {
            throw new NotPositiveNumberException(NOT_POSITIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validCheckRightAmountUnit(String amount) {
        if (!isRightAmountUnit(amount)) {
            throw new LottoAmountUnitException(AMOUNT_UNIT_ERROR_MESSSAGE);
        }
    }

    public double findProfitsRatio(int profitMoney) {
        double profit = (double) profitMoney / this.amount;
        return Math.floor(profit * FLOOR_STAND_DELIMETER) / FLOOR_STAND_DELIMETER;
    }

    private boolean isRightAmountUnit(String amount) {
        return Integer.parseInt(amount) % AMOUNT_PER_LOTTO ==0;
    }

    @Override
    public boolean equals(Object obj) {
        LottoPurchaseAmount target = (LottoPurchaseAmount) obj;
        return this.amount == target.amount;
    }

    public int getBuyableAutoLottoNumbers(String manualLottoCountToBuy) {
        return getQuantityPerAmountLotto() - Integer.parseInt(manualLottoCountToBuy);
    }

    private int maxBuyableLottoCount() {
        return this.amount / AMOUNT_PER_LOTTO;
    }

    public void validCheckBuyableLotto(final String lottoCountToBuy) {
        validCheckPositiveNumber(lottoCountToBuy);

        if (Integer.parseInt(lottoCountToBuy) == ZERO) {
            throw new BuyableLottoNumberSizeException(NOT_BUYABLE_ZERO_LOTTO_SIZE_ERROR_MESSAGE);
        }

        if ( maxBuyableLottoCount() - Integer.parseInt(lottoCountToBuy) < 0 ) {
            throw new BuyableLottoNumberSizeException(BUYABLE_LOTTO_NUMBER_SIZE_EXCESS_ERROR_MESSAGE);
        }
    }
}
