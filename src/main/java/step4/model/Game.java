package step4.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private List<LottoResult> lottoResults = new ArrayList<>();
    private LottoBuyCount lottoBuyCount;
    private Money buyMoney;

    public Game() {

    }

    public Game(int count) {
        this.lottoBuyCount = new LottoBuyCount(count);
    }

    public Game(String money) {
        this.buyMoney = new Money(money);
        this.lottoBuyCount = new LottoBuyCount(this.buyMoney);
    }

    public LottoBuyCount getLottoBuyCount() {
        return lottoBuyCount;
    }

    public void startLottoGame() {
        List<LottoResult> result = new ArrayList<>();
        LottoBuyCount index = new LottoBuyCount(0);
        while (!index.equals(this.lottoBuyCount)) {
            result.add(lottoGenerator.createLottoResult());
            index.plus();
        }
        this.lottoResults = result;
    }

    public List<LottoResult> getLottoResults() {
        return this.lottoResults;
    }

    public double getProfitPercent(LottoWinningStatistics lottoWinningStatistics) {
        return lottoWinningStatistics.getTotalProfitPercent(buyMoney);
    }
}