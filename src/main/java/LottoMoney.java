public class LottoMoney {
    private long money;

    private LottoMoney(long money) {
        if (money < 0) {
            throw new IllegalArgumentException("적절하지 않은 금액입니다.");
        }

        this.money = money;
    }

    public static LottoMoney empty() {
        return new LottoMoney(0);
    }

    public static LottoMoney of(long money) {
        return new LottoMoney(money);
    }

    public boolean canBuy() {
        return this.money >= Vendor.LOTTO_PRICE;
    }

    public void buy(Lotto lotto) {
        checkCanBuy(lotto.size());
        this.money -= (long) Vendor.LOTTO_PRICE * lotto.size();
    }

    public void buyOne() {
        checkCanBuy(1);
        this.money -= Vendor.LOTTO_PRICE;
    }

    private void checkCanBuy(int count) {
        if (this.money < (long) Vendor.LOTTO_PRICE * count) {
            throw new IllegalArgumentException("이 돈으로는 로또를 구매할 수 없습니다.");
        }
    }
}
