package step3.model;

import step3.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<LottoResult> lottoResults = new ArrayList<>();
    private LottoResult winLottoResult;
    private LottoBuyCount lottoBuyCount;
    private Money buyMoney;
    private LottoWinningStatistics lottoWinningStatistics;
    private final LottoGenerator lottoGenerator = new LottoGenerator();

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

    public LottoResult getWinLottoResult() {
        return this.winLottoResult;
    }

    public void setWinLottoResult(String numbersStr) {
        winLottoResult = new LottoResult(StringUtil.parseLottoText(numbersStr));
    }

    public void startLottoWinningStatistics() {
        lottoWinningStatistics = new LottoWinningStatistics(this.lottoResults, this.winLottoResult);
    }

    public LottoWinningStatistics getLottoWinningStatistics() {
        return lottoWinningStatistics;
    }

    public double getProfitPercent() {
        return lottoWinningStatistics.getTotalProfitPercent(buyMoney);
    }
}
