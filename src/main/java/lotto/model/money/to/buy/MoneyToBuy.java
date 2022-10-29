package lotto.model.money.to.buy;

import lotto.constant.numbers.LottoConstant;

/**
 * 로또 구매를 위해 입력한 금액을 저장하는 객체
 */
public class MoneyToBuy {
    protected int money;
    private double profitRatio;

    public MoneyToBuy(String input) {
        int inputMoney;
        try {
            inputMoney = Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException("구입 금액은 반드시 숫자여야 합니다.");
        }
        if (isNegative(inputMoney)) {
            throw new NumberFormatException("구입 금액은 음수가 될 수 없습니다.");
        }
        money = inputMoney / LottoConstant.PRICE_OF_SINGLE_LOTTO_TICKET * LottoConstant.PRICE_OF_SINGLE_LOTTO_TICKET;
    }

    private boolean isNegative(int input) {
        return input < 0;
    }

    public int numberOfAffordableLottoTickets() {
        return money / LottoConstant.PRICE_OF_SINGLE_LOTTO_TICKET;
    }
}
