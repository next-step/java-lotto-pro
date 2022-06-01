package lotto;

import lotto.config.LottoGameConfig;

public class LottoMoneyChecker {
    public int calculatePurchasingCount(int money) {
        validateMoney(money);
        return money / LottoGameConfig.PURCHASE_MONEY;
    }

    public void validateMoney(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("money는 1 이상이어야 합니다.");
        }
    }

    public void validateCountOfManualGame(int count, int money) {
        if (count < 0) {
            throw new IllegalArgumentException("CountOfManualGame는 0이상이어야 합니다.");
        }

        if (count > calculatePurchasingCount(money)) {
            throw new IllegalArgumentException("CountOfManualGame는 전체 구매가능한 갯수보다 같거나 작은 값이어야 합니다.");
        }
    }
}
