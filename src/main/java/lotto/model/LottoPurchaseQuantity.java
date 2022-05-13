package lotto.model;

public class LottoPurchaseQuantity {
    private static final String MONEY_FORMAT_REGEX = "^[1-9]+[0-9]*$";
    private static final int LOTTO_PRICE = 1000;

    private final int quantity;

    public LottoPurchaseQuantity(String money) {
        validateFormat(money);
        validateAmount(money);
        quantity = calculateQuantity(Integer.parseInt(money));
    }

    private int calculateQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    private void validateAmount(String money) {
        if (isLessThanLottoPrice(money)) {
            throw new IllegalArgumentException("로또 한 장의 금액보다 입력한 금액이 적습니다.");
        }
    }

    private boolean isLessThanLottoPrice(String money) {
        return Integer.parseInt(money) < LOTTO_PRICE;
    }

    private void validateFormat(String money) {
        if (isNotValid(money)) {
            throw new IllegalArgumentException("올바른 금액 양식이 아닙니다.");
        }
    }

    private boolean isNotValid(String money) {
        return isNull(money) || isInvalidFormat(money);
    }

    private boolean isNull(String money) {
        return money == null;
    }

    private boolean isInvalidFormat(String money) {
        return !money.matches(MONEY_FORMAT_REGEX);
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPurchasePrice() {
        return quantity * LOTTO_PRICE;
    }
}
