package lotto.domain;

public class Money {
    private static final String INPUT_AMOUNT_ERROR = "잘못된 금액을 입력하였습니다.";
    private static final String INPUT_MANUAL_AMOUNT_ERROR = "수동 입력 개수는 로또 구매 개수를 초과할 수 없습니다.";
    private static final int LOTTO_PRICE = 1000;

    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount, int manualCount) {
        validAmount(amount);
        validCount(amount);
        int allCount = amount/LOTTO_PRICE;
        validManualCount(allCount, manualCount);

        return new Money(amount);
    }

    private static void validAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT_ERROR);
        }
    }

    private static void validCount(int amount) {
        if (amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(INPUT_AMOUNT_ERROR);
        }
    }

    private static void validManualCount(int allCount, int manualCount) {
        if (allCount < manualCount) {
            throw new IllegalArgumentException(INPUT_MANUAL_AMOUNT_ERROR);
        }
    }

    public int getAmount() {
        return this.amount;
    }
    public int getAllCount() {
        return amount/LOTTO_PRICE;
    }
}
