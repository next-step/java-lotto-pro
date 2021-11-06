package lotto.domain;

import static lotto.domain.LottoPattern.*;

public class LottoMoney {
    private final int amount;

    public LottoMoney(String amount) {
        validatePositiveNumber(amount);
        this.amount = Integer.parseInt(amount);
        validateAmountUnit();
    }

    private void validatePositiveNumber(String amount) {
        if (!ONLY_POSITIVE_NUMBER.matcher(amount).matches()) {
            throw new IllegalArgumentException(Message.NON_POSITIVE_NUMBER_MESSAGE.getMessage());
        }
    }

    private void validateAmountUnit() {
        int lottoAmountUnit = LottoAmountUnit.LOTTO_AMOUNT_UNIT.getUnit();
        if (amount < lottoAmountUnit
            || amount % lottoAmountUnit != LottoAmountUnit.LOTTO_AMOUNT_UNIT_MODULO.getUnit()) {
            throw new IllegalArgumentException(Message.WRONG_LOTTO_AMOUNT_UNIT.getMessage());
        }
    }

    public int getCountOfPossibleLotto() {
        return amount / LottoAmountUnit.LOTTO_AMOUNT_UNIT.getUnit();
    }

    public double calculateProfitRatio(long winningAmount) {
        int profitRatioScale = LottoAmountUnit.PROFIT_RATIO_SCALE.getUnit();
        double profitRatio = (double)winningAmount / amount;
        return Math.floor(profitRatio * profitRatioScale) / profitRatioScale;
    }

    private enum LottoAmountUnit {
        LOTTO_AMOUNT_UNIT(1000),
        LOTTO_AMOUNT_UNIT_MODULO(0),
        PROFIT_RATIO_SCALE(100);

        private final int unit;

        LottoAmountUnit(int unit) {
            this.unit = unit;
        }

        public int getUnit() {
            return unit;
        }
    }
}
