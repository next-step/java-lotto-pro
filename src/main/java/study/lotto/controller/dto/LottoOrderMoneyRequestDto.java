package study.lotto.controller.dto;

public class LottoOrderMoneyRequestDto {
    private final int orderCount;

    public LottoOrderMoneyRequestDto(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
