package step3.model;

import step3.constant.ErrorMessageConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Game {
    private static final int LOTTO_ONE_GAME_MONEY = 1000;
    private static final int LOTTO_LENGTH = 6;
    private static final String DELIMITER = ",";
    private final List<Integer> lottoCandidateNumbers = new ArrayList<>();
    private final List<List<Integer>> lottoResult = new ArrayList<>();
    private final List<Integer> winLottoNumbers = new ArrayList<>();
    private int lottoBuyCount;

    public Game() {
        initLottoCandidateNumbers();
    }

    public Game(int count) {
        this.lottoBuyCount = count;
        initLottoCandidateNumbers();

    }

    public Game(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageConstant.EMPTY_TEXT);
        }
        this.lottoBuyCount = getLottoBuyCount(convertNumber(money));
        initLottoCandidateNumbers();

    }

    private void initLottoCandidateNumbers() {
        for (int i = 1; i < 46; i++) {
            this.lottoCandidateNumbers.add(i);
        }
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

    public List<List<Integer>> getLottoResult() {
        for (int i = 0; i < lottoBuyCount; i++) {
            Collections.shuffle(this.lottoCandidateNumbers);
            this.lottoResult.add(this.lottoCandidateNumbers.subList(0, 6));
            Collections.sort(this.lottoResult.get(i));
        }
        return this.lottoResult;
    }

    public List<Integer> getWinLottoNumbers() {
        return this.winLottoNumbers;
    }

    public void setWinLottoNumbers(String numbersStr) {
        String[] splitNumbers = numbersStr.split(DELIMITER);
        for (String numberStr : splitNumbers) {
            this.winLottoNumbers.add(convertNumber(numberStr.trim()));
        }
        if (this.winLottoNumbers.size() != LOTTO_LENGTH) {
            throw new RuntimeException(ErrorMessageConstant.NOT_LOTTO_SIZE);
        }
    }
}
