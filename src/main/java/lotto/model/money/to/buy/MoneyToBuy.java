package lotto.model.money.to.buy;

public class MoneyToBuy {
    private static final int PRICE_OF_SINGLE_LOTTO_TICKET = 1000;
    protected final int money;
    private int boughtLottoCount;

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
        if (!divisibleWithoutRemainder(inputMoney)) {
            throw new NumberFormatException("구입 금액은 로또 한 장 가격 단위로 입력해주세요. (로또 한 장 가격: 1000 원)");
        }
        money = inputMoney;
    }

    private boolean isNegative(int input) {
        return input < 0;
    }

    private boolean divisibleWithoutRemainder(int inputMoney) {
        return inputMoney % PRICE_OF_SINGLE_LOTTO_TICKET == 0;
    }

    public double profitRatio(double sumOfPrizesFromLottoResult) {
        return sumOfPrizesFromLottoResult / money;
    }

    public int value() {
        return money;
    }
}
