package lotto.service;

public class LottoMoneyService {
    private static final int PURCHASE_MONEY = 1000;

    public int calculatePurchasingCount(int money) {
        validateMoney(money);
        return money / PURCHASE_MONEY;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("money는 음수일 수 없습니다.");
        }
    }
}
