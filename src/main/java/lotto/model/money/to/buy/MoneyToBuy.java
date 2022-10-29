package lotto.model.money.to.buy;

/**
 * 로또 구매를 위해 입력한 금액을 저장하는 객체
 */
public class MoneyToBuy {
    private int money;

    public MoneyToBuy(String input) {
        try {
            money = Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException("구입 금액은 반드시 숫자여야 합니다.");
        }

        if (isNegative(money)) {
            throw new NumberFormatException("구입 금액은 음수가 될 수 없습니다.");
        }
    }

    private boolean isNegative(int input) {
        return input < 0;
    }
}
