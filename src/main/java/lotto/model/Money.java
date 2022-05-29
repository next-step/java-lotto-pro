package lotto.model;

import lotto.Config;

public class Money {
    private final int receiveAmount;
    private final int manualCount;

    public Money(int money) {
        this.receiveAmount = checkAmount(money);
        this.manualCount = 0;
    }

    public Money(int money, int manualCount) {
        this.receiveAmount = checkAmount(money);
        this.manualCount = checkManualCount(manualCount);
    }

    public int receiveAmount() {
        return this.receiveAmount;
    }

    public int buyCount() {
        return this.receiveAmount / Config.LOTTO_ONE_GAME_PRICE;
    }

    public int buyManualCount() {
        return this.manualCount;
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

    private int checkManualCount(int manualCount) {
        if (buyCount() < manualCount) {
            throw new IllegalArgumentException(String.format("수동 구매는 최대 %d개 까지 가능합니다.", buyCount()));
        }
        return manualCount;
    }
}
