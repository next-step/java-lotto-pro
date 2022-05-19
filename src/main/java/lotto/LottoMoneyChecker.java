package lotto;

import lotto.config.LottoGameConfig;

public class LottoMoneyChecker {
    public int calculatePurchasingCount(int money) {
        validateMoney(money);
        return money / LottoGameConfig.PURCHASE_MONEY;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("money는 음수일 수 없습니다.");
        }
    }
}
