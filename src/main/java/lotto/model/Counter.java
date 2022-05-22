package lotto.model;

import lotto.Config;

public class Counter {
    private final int receiveAmount;

    public Counter(int money) {
        this.receiveAmount = checkAmount(money);
    }

    public int receiveAmount () {
        return this.receiveAmount;
    }

    public int buyCount () {
        return this.receiveAmount / Config.LOTTO_ONE_GAME_PRICE;
    }

    private int checkAmount(int amount) {
        if (amount < Config.LOTTO_ONE_GAME_PRICE) {
            throw new IllegalArgumentException(String.format("최소 금액은 %d원 이상입니다.", Config.LOTTO_ONE_GAME_PRICE));
        }

        if (amount % Config.LOTTO_ONE_GAME_PRICE != 0) {
            throw new IllegalArgumentException(String.format("금액은 %s원 단위로 입력해주세요.", Config.LOTTO_ONE_GAME_PRICE));
        }
        return amount;
    }

}
