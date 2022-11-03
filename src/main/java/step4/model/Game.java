package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoBuyCount lottoAutoBuyCount;
    private Money buyMoney;

    public Game(int count) {
        this.lottoAutoBuyCount = new LottoBuyCount(count);
    }

    public Game(String money) {
        this.buyMoney = new Money(money);
        this.lottoAutoBuyCount = new LottoBuyCount(this.buyMoney);
    }

    public Game(Money money, LottoBuyCount manualLottoBuyCount) {
        this.buyMoney = money;
        this.lottoAutoBuyCount = new LottoBuyCount(this.buyMoney).minus(manualLottoBuyCount);
    }

    public LottoBuyCount getLottoAutoBuyCount() {
        return lottoAutoBuyCount;
    }

    public Lottos startLottoGame() {
        List<Lotto> result = new ArrayList<>();
        LottoBuyCount index = new LottoBuyCount(0);
        while (!index.equals(this.lottoAutoBuyCount)) {
            result.add(lottoGenerator.createLotto());
            index.plus();
        }
        return new Lottos(result);
    }

    public Money getBuyMoney() {
        return buyMoney;
    }
}
