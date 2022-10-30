package lotto.domain;

public class PayAmount {

    public static final int LOTTO_PRICE = 1000;
    private final int payAmount;

    public PayAmount(int payAmount) {
        this.payAmount = payAmount;
    }

    public int lottoAmount() {
        return payAmount / LOTTO_PRICE;
    }
}
