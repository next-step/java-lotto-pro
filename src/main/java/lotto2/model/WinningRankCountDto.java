package lotto2.model;

public class WinningRankCountDto {
    private final LottoPrizeEnum lottoPrizeEnum;
    private final int count;

    public WinningRankCountDto(LottoPrizeEnum lottoPrizeEnum, int count) {
        this.lottoPrizeEnum = lottoPrizeEnum;
        this.count = count;
    }

    public LottoPrizeEnum getLottoPrizeEnum() {
        return lottoPrizeEnum;
    }

    public int getCount() {
        return count;
    }
}
