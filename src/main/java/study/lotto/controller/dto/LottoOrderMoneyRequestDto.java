package study.lotto.controller.dto;

public class LottoOrderMoneyRequestDto {
    private final int money;

    public LottoOrderMoneyRequestDto(final int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
}
