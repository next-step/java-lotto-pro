package step3.model;

import step3.constant.ErrorMessageConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static final int LOTTO_ONE_GAME_MONEY = 1000;
    private static final String DELIMITER = "\\s*,\\s*";
    private final List<LottoNumber> lottoCandidateNumbers = new ArrayList<>();
    private final List<LottoResult> lottoResults = new ArrayList<>();
    private LottoResult winLottoNumbers;
    private int lottoBuyCount;
    private int money;

    public Game() {
        initLottoCandidateNumbers();
    }

    public Game(int count) {
        this.lottoBuyCount = count;
        checkLottoBuyCount();
        initLottoCandidateNumbers();
    }

    public Game(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.money = convertNumber(money);
        this.lottoBuyCount = getLottoBuyCount(this.money);
        checkLottoBuyCount();
        initLottoCandidateNumbers();
    }

    private void initLottoCandidateNumbers() {
        for (int i = 1; i < 46; i++) {
            this.lottoCandidateNumbers.add(new LottoNumber(i));
        }
    }

    private void checkLottoBuyCount() {
        if (this.lottoBuyCount < 0) {
            throw new RuntimeException(ErrorMessageConstant.ZERO_LOTTO_COUNT);
        }
    }

    public int getMoney() {
        return money;
    }

    private int getLottoBuyCount(int money) {
        return money / LOTTO_ONE_GAME_MONEY;
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
        for (int i = 0; i < lottoBuyCount; i++) {
            Collections.shuffle(this.lottoCandidateNumbers);
            this.lottoResults.add(new LottoResult(new ArrayList<>(this.lottoCandidateNumbers.subList(0, 6))));
        }
        return this.lottoResults;
    }

    public LottoResult getWinLottoNumbers() {
        return this.winLottoNumbers;
    }

    public void setWinLottoNumbers(String numbersStr) {
        String[] splitNumbers = numbersStr.split(DELIMITER);
        winLottoNumbers = new LottoResult(splitNumbers);
    }

    public LottoWinningStatistics getLottoWinningStatistics() {
        return new LottoWinningStatistics(this.lottoResults, this.winLottoNumbers);
    }
}
