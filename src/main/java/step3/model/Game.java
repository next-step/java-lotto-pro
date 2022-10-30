package step3.model;

import step3.constant.ErrorMessageConstant;
import step3.constant.LottoConstant;
import step3.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<LottoResult> lottoResults = new ArrayList<>();
    private LottoResult winLottoResult;
    private int lottoBuyCount;
    private int money;
    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public Game() {

    }

    public Game(int count) {
        this.lottoBuyCount = count;
        checkLottoBuyCount();
    }

    public Game(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.money = convertNumber(money);
        this.lottoBuyCount = getLottoBuyCount(this.money);
        checkLottoBuyCount();
    }

    private void checkLottoBuyCount() {
        if (this.lottoBuyCount <= 0) {
            throw new RuntimeException(ErrorMessageConstant.ZERO_LOTTO_BUY_COUNT);
        }
    }

    public int getMoney() {
        return money;
    }

    private int getLottoBuyCount(int money) {
        return money / LottoConstant.LOTTO_ONE_GAME_MONEY;
    }

    private int convertNumber(String text) {
        int result;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessageConstant.NOT_NUMBER);
        }
        if (result < 0) {
            throw new NumberFormatException(ErrorMessageConstant.NEGATIVE_NUMBER);
        }
        return result;
    }

    public int getLottoBuyCount() {
        return lottoBuyCount;
    }

    public List<LottoResult> getLottoResults() {
        List<LottoResult> result = new ArrayList<>();
        for (int i = 0; i < lottoBuyCount; i++) {
            result.add(lottoGenerator.createLottoResult());
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
