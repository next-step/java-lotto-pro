package lotto.domain;

import java.util.regex.Pattern;

public class LottoMoney {
    public static final int LOTTO_AMOUNT_UNIT = 1000;
    public static final int PROFIT_RATIO_SCALE = 100;
    public static final int LOTTO_AMOUNT_UNIT_MODULO = 0;
    private static final Pattern ONLY_POSITIVE_NUMBER = Pattern.compile("[0-9]+");

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
        if (this.amount < LOTTO_AMOUNT_UNIT || this.amount % LOTTO_AMOUNT_UNIT != LOTTO_AMOUNT_UNIT_MODULO) {
            throw new IllegalArgumentException(Message.WRONG_LOTTO_AMOUNT_UNIT.getMessage());
        }
    }

    public int countOfPossibleLotto() {
        return amount / LOTTO_AMOUNT_UNIT;
    }

    public double profitRatio(long winningAmount) {
        double profitRatio = (double)winningAmount / amount;
        return Math.floor(profitRatio * PROFIT_RATIO_SCALE) / PROFIT_RATIO_SCALE;
    }
}
