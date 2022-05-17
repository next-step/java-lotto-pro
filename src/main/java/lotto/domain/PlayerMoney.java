package lotto.domain;

public class PlayerMoney {
    private int money;
    private PlayerMoney(int money) {
        valid(money);
        this.money = money;
    }

    public static PlayerMoney of(int money) {
        return new PlayerMoney(money);
    }

    public void deduction(int money) {
        if (this.money < money) {
            throw new IllegalArgumentException("뺄 금액은 남은 금액보다 큽니다.");
        }
        this.money -= money;
    }

    public int remainMoney() {
        return money;
    }

    public int buyAbleMaxLottoQty() {
        return money / Lotto.LOTTO_MONEY;
    }

    private void valid(int money) {
        if (money < Lotto.LOTTO_MONEY) {
            throw new IllegalArgumentException("로또 살돈이 모자릅니다.");
        }
    }
}
