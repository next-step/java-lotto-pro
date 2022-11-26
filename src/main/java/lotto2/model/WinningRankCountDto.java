package lotto2.model;

import lotto2.model.enums.LottoPrize;

public class WinningRankCountDto {
    private final LottoPrize lottoPrize;
    private final int count;

    public WinningRankCountDto(LottoPrize lottoPrize, int count) {
        this.lottoPrize = lottoPrize;
        this.count = count;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    public int getCount() {
        return count;
    }
}
