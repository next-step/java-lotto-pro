package study.step3.domain.lotto;

public class PurchaseMoney {

    private static final Money ONE_LOTTO_PRICE = new Money(1_000L);
    private final Money money;

    public PurchaseMoney(Money money) {
        this.money = money;
    }

    public static PurchaseMoney of(long money) {
        return new PurchaseMoney(Money.of(money));
    }

    public long money() {
        return this.money.money();
    }

    public long numberOfRandomLottos(long manualLottoCount) {
        long totalLottoCount = money() / ONE_LOTTO_PRICE.money();
        return totalLottoCount - manualLottoCount;
    }

    public boolean isLackOfMoney(long manualLottoCount) {
        return numberOfRandomLottos(manualLottoCount) < 0L;
    }
}
