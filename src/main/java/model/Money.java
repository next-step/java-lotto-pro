package model;

public class Money {

    private final int money;

    private static final int LOTTO_PRICE = 1000;

    public Money(int inputMoney) {
        if (inputMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException("1000원 이상의 금액을 입력해주세요.");
        }

        this.money = inputMoney;
    }

    private int availableBuyLottoCount() {
        return this.money / LOTTO_PRICE;
    }

    public int availableBuyAutoLottoCount(int manualCount) {
        return this.availableBuyLottoCount() - manualCount;
    }
}
