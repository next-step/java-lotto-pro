package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import lotto.view.OutputView;

public class Amount {

    private final static int MIN_AMOUNT = 1_000;

    private static final int MIN_BUY_LOTTO_COUNT = 1;

    private static final  String NOT_ALLOW_NULL_OR_EMPTY_MESSAGE = "금액은 Null 또는 Empty 값이 불가능합니다.";

    private final static String ONLY_NUMBER_MESSAGE = "금액은 숫자만 입력 가능합니다.";

    private final static String ONLY_POSITIVE_MESSAGE = "금액은 양수만 입력 가능합니다.";

    private final static String MIN_BUY_LOTTO_MESSAGE = "로또는 1개 이상 구매해야 합니다.";

    private final int amount;

    public Amount(final String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
    }

    private void validate(final String amount) {
        validateNullOrEmpty(amount);
        validateNumber(amount);
        validatePositive(amount);
    }

    private void validateNullOrEmpty(final String amount) {
        if (Objects.isNull(amount) || amount.isEmpty()) {
            throw new IllegalArgumentException(NOT_ALLOW_NULL_OR_EMPTY_MESSAGE);
        }
    }

    private void validateNumber(final String amount) {
        if (!amount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ONLY_NUMBER_MESSAGE);
        }
    }

    private void validatePositive(final String amount) {
        if (!Pattern.matches("^[0-9]*$", amount)) {
            throw new IllegalArgumentException(ONLY_POSITIVE_MESSAGE);
        }
    }

    public int buyLottoCount() {
        int buyLottoCount = this.amount / MIN_AMOUNT;

        if (buyLottoCount < MIN_BUY_LOTTO_COUNT) {
            throw new IllegalArgumentException(MIN_BUY_LOTTO_MESSAGE);
        }

        return buyLottoCount;
    }

    public static double calculateLottoYield(Amount buyAmount, Map<LottoRank, Integer> rankInfo) {
        int totalAmount = 0;
        for (LottoRank lottoRank: LottoRank.reverse()) {
            totalAmount += lottoRank.getWinningMoney() * rankInfo.get(lottoRank);
        }
        BigDecimal totalAmountBigDecimal = new BigDecimal(totalAmount);
        BigDecimal buyAmountBigDecimal = new BigDecimal(buyAmount.getBuyAmount());

        return totalAmountBigDecimal.divide(buyAmountBigDecimal, 2, RoundingMode.HALF_UP).doubleValue();
    }

    public int getBuyAmount() {
        return this.amount / MIN_AMOUNT * MIN_AMOUNT;
    }
}
