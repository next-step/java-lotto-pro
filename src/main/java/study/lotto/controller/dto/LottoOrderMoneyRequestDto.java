package study.lotto.controller.dto;

import study.lotto.model.Money;

public class LottoOrderMoneyRequestDto {
    private final int money;

    public LottoOrderMoneyRequestDto(final int money) {
        this.money = money;
    }

    public Money toEntity() {
        return Money.valueOf(money);
    }
}
