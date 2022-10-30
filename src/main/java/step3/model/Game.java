package step3.model;

import step3.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<LottoResult> lottoResults = new ArrayList<>();
    private LottoResult winLottoResult;
    private LottoBuyCount lottoBuyCount;
    private Money money;
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Game() {

    }

    public Game(int count) {
        this.lottoBuyCount = new LottoBuyCount(count);
    }

    public Game(String money) {
        this.money = new Money(money);
        this.lottoBuyCount = new LottoBuyCount(this.money);
    }

    public Money getMoney() {
        return money;
    }

    public LottoBuyCount getLottoBuyCount() {
        return lottoBuyCount;
    }

    public List<LottoResult> getLottoResults() {
        List<LottoResult> result = new ArrayList<>();
        LottoBuyCount index = new LottoBuyCount(0);
        while (!index.equals(this.lottoBuyCount)) {
            result.add(lottoGenerator.createLottoResult());
            index.plus();
        }
        this.lottoResults = result;
        return this.lottoResults;
    }

    public LottoResult getWinLottoResult() {
        return this.winLottoResult;
    }

    public void setWinLottoResult(String numbersStr) {
        winLottoResult = new LottoResult(StringUtil.parseLottoText(numbersStr));
    }

    public LottoWinningStatistics getLottoWinningStatistics() {
        return new LottoWinningStatistics(this.lottoResults, this.winLottoResult);
    }
}
