package step3.domain;

public class LottoBuyCount {
    private final int manualLottoBuyCount;
    private final int autoLottoBuyCount;

    private LottoBuyCount(int manualLottoBuyCount, int autoLottoBuyCount) {
        this.manualLottoBuyCount = manualLottoBuyCount;
        this.autoLottoBuyCount = autoLottoBuyCount;
    }

    public int getManualLottoBuyCount() {
        return manualLottoBuyCount;
    }

    public int getAutoLottoBuyCount() {
        return autoLottoBuyCount;
    }

    public static class Builder {
        int manualLottoBuyCount;
        int autoLottoBuyCount;

        public Builder setLottoManualLottoBuyCount(int manualLottoBuyCount) {
            this.manualLottoBuyCount = manualLottoBuyCount;
            return this;
        }

        public Builder setLottoAutoLottoBuyCount(int autoLottoBuyCount) {
            this.autoLottoBuyCount = autoLottoBuyCount;
            return this;
        }

        public LottoBuyCount build() {
            return new LottoBuyCount(manualLottoBuyCount, autoLottoBuyCount);
        }
    }
}
