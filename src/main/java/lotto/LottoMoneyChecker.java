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
}
