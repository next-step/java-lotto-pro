package lotto.model;

public class Coin {
    private final int deposit;
    private static final int LOTTO_PRICE = 1000;

    public Coin(String money) {
        invalidMoneyCheck(money);
        this.deposit = Integer.parseInt(money) / LOTTO_PRICE * LOTTO_PRICE;
        minimumPriceCheck();
    }

    public int getDeposit() {
        return deposit;
    }

    public int maxCountOfLotto() {
        return deposit / LOTTO_PRICE;
    }

    private void invalidMoneyCheck(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
    }

    private void minimumPriceCheck() {
        if (deposit < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구입금액은 " + LOTTO_PRICE + "원 입니다.");
        }
    }
}
