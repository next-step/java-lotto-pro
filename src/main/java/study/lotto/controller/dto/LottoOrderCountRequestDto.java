package study.lotto.controller.dto;

public class LottoOrderCountRequestDto {
    private final int orderCount;

    public LottoOrderCountRequestDto(int orderCount) {
        this.orderCount = orderCount;
    }

    public int getOrderCount() {
        return orderCount;
    }
}
