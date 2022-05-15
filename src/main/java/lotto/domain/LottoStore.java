package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static lotto.constant.LottoWinningConstant.*;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;
    private int lottoCount;
    private List<LottoNumbers> lottoAutoNumbers = new ArrayList<>();
    private HashMap<Integer, Integer> lottoResult = initializeLottoResult();
    private HashMap<Integer, Integer> lottoCashPrize = initializeLottoCashPrize();

    public LottoStore(Money money) {
        this.lottoCount = money.getMoney() / LOTTO_PRICE;
    }

    public HashMap<Integer, Integer> initializeLottoResult() {
        HashMap<Integer, Integer> lottoResult = new HashMap<>();
        lottoResult.put(MATCH_THREE, 0);
        lottoResult.put(MATCH_FOUR, 0);
        lottoResult.put(MATCH_FIVE, 0);
        lottoResult.put(MATCH_SIX, 0);
        return lottoResult;
    }

    public HashMap<Integer, Integer> initializeLottoCashPrize() {
        HashMap<Integer, Integer> lottoCashPrize = new HashMap<>();
        lottoCashPrize.put(MATCH_THREE, MATCH_THREE_CASH_PRIZE);
        lottoCashPrize.put(MATCH_FOUR, MATCH_FOUR_CASH_PRIZE);
        lottoCashPrize.put(MATCH_FIVE, MATCH_FIVE_CASH_PRIZE);
        lottoCashPrize.put(MATCH_SIX, MATCH_SIX_CASH_PRIZE);
        return lottoCashPrize;
    }

    public void buy() {
        for (int i = 0; i < lottoCount; i++) {
            lottoAutoNumbers.add(new LottoNumbers(LottoAutoGenerator.makeNumbers()));
        }
    }

    public void calculateWinningResult(LottoNumbers winningNumbers) {
        HashSet<Integer> winningNumberSet = new HashSet<>(winningNumbers.getLottoNumbers());
        for (LottoNumbers lottoAutoNumber : lottoAutoNumbers) {
            int matchCount = lottoAutoNumber.calculateMatchCount(winningNumberSet);
            calculateMatchResult(matchCount);
        }
    }

    private void calculateMatchResult(int matchCount) {
        if (matchCount == MATCH_THREE) {
            lottoResult.put(MATCH_THREE, lottoResult.get(MATCH_THREE) + 1);
        }
        if (matchCount == MATCH_FOUR) {
            lottoResult.put(MATCH_FOUR, lottoResult.get(MATCH_FOUR) + 1);
        }
        if (matchCount == MATCH_FIVE) {
            lottoResult.put(MATCH_FIVE, lottoResult.get(MATCH_FIVE) + 1);
        }
        if (matchCount == MATCH_SIX) {
            lottoResult.put(MATCH_SIX, lottoResult.get(MATCH_SIX) + 1);
        }
    }

    public float calculateRateOfReturn() {
        int inputMoney = LOTTO_PRICE * lottoCount;
        int profits = 0;

        for (int matchCount : lottoResult.keySet()) {
            profits += lottoResult.get(matchCount) * lottoCashPrize.get(matchCount);
        }
        return profits / inputMoney;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public HashMap<Integer, Integer> getLottoResult() {
        return lottoResult;
    }

    public List<LottoNumbers> getLottoAutoNumbers() {
        return lottoAutoNumbers;
    }
}
