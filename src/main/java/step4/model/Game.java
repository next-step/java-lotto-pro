package step4.model;

import step4.constant.ErrorMessageConstant;
import step4.exception.LottoFormatException;
import step4.model.generator.LottoGenerator;

public class Game {
    private final LottoBuyCount totalLottoBuyCount;
    private Money buyMoney;

    public Game(int count) {
        this.totalLottoBuyCount = new LottoBuyCount(count);
    }

    public Game(String money) {
        this.buyMoney = new Money(money);
        this.totalLottoBuyCount = new LottoBuyCount(this.buyMoney);
    }

    public Game(Money money, LottoBuyCount manualBuyCount) {
        this.buyMoney = money;
        this.totalLottoBuyCount = new LottoBuyCount(this.buyMoney);
        if (totalLottoBuyCount.isLessThan(manualBuyCount)) {
            throw new LottoFormatException(ErrorMessageConstant.MANUAL_BUY_LOTTO_GREATER_THAN_TOTAL_BUY_LOTTO);
        }
    }

    public LottoBuyCount getLottoAutoBuyCount(LottoBuyCount manualLottoBuyCount) {
        if (totalLottoBuyCount.isLessThan(manualLottoBuyCount)) {
            throw new LottoFormatException(ErrorMessageConstant.MANUAL_BUY_LOTTO_GREATER_THAN_TOTAL_BUY_LOTTO);
        }
        return totalLottoBuyCount.minus(manualLottoBuyCount);
    }

    public Lottos startLottoGame(LottoGenerator lottoGenerator) {
        return lottoGenerator.createLottos();
    }
}
