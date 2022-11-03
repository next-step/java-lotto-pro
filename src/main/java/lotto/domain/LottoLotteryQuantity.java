package lotto.domain;

import java.util.Optional;

public class LottoLotteryQuantity {
    private final LottoPurchaseQuantity autoQuantity;
    private final LottoPurchaseQuantity manualQuantity;

    private LottoLotteryQuantity(LottoPurchaseQuantity autoQuantity, LottoPurchaseQuantity manualQuantity) {
        this.autoQuantity = autoQuantity;
        this.manualQuantity = manualQuantity;
    }

    public static LottoLotteryQuantity of(LottoPurchaseAmount lottoPurchaseAmount, LottoPurchaseQuantity manualQuantity) {
        return new LottoLotteryQuantity(lottoPurchaseAmount.calculateAutoQuantity(manualQuantity), manualQuantity);
    }

    public Optional<LottoLottery> toManualLottoLottery() {
        return manualQuantity.toManualLottoLottery();
    }

    public LottoLottery toAutoLottoLottery() {
        return autoQuantity.toAutoLottoLottery();
    }

    public String history() {
        return LottoPurchaseQuantity.history(manualQuantity, autoQuantity);
    }
}
