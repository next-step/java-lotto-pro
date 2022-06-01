package lotto;

import static lotto.config.LottoGameConfig.PURCHASE_MONEY;

public class LottoMoneyChecker {
    public int calculatePurchasingAutoGameCount(int countOfManualCount, int money) {
        int change = money - (countOfManualCount * PURCHASE_MONEY);
        int count = change / PURCHASE_MONEY;
        return Math.max(count, 0);
    }

    public void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("money는 1 이상이어야 합니다.");
        }
    }

    public void validateCountOfManualGame(int countOfManualGame, int money) {
        if (countOfManualGame < 0) {
            throw new IllegalArgumentException("CountOfManualGame는 0이상이어야 합니다.");
        }

        if (countOfManualGame * PURCHASE_MONEY > money) {
            throw new IllegalArgumentException("CountOfManualGame는 전체 구매가능한 갯수보다 같거나 작은 값이어야 합니다.");
        }
    }
}
