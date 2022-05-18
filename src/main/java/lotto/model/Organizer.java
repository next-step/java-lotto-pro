package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Organizer {
    private static final int COMPARE_TRUE = 1;
    private static final int COMPARE_FALSE = 0;
    private static final int INIT_RESULT_COUNT = 0;

    private final List<Integer> winnerNumbers;
    private Map<Integer, Integer> winningResults;
    private long totalWinningMoney;

    public Organizer(String number) {
        winnerNumbers = Arrays.stream(number.split(","))
                .map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int userNumberSameCount(Lotto lotto) {
        int sameCount = 0;
        for (int number : lotto.seeNumbers()) {
            sameCount += compare(number);
        }
        return sameCount;
    }

    public Map<Integer, Integer> winningResults(Lottos lottos) {
        initWinningResult();
        for (Lotto lotto : lottos.allGames()) {
            countWinning(userNumberSameCount(lotto));
        }
        return winningResults;
    }

    public String winningRate(int buyAmount) {
        return String.format("%.2f", this.totalWinningMoney / (double) buyAmount);
    }

    private void initWinningResult() {
        this.winningResults = new HashMap<>();
        for (WinningInfo winningInfo : WinningInfo.values()) {
            winningResults.put(winningInfo.sameCount(), INIT_RESULT_COUNT);
        }
    }

    private void countWinning(int sameCount) {
        if (sameCount < WinningInfo.SAME_COUNT_3.sameCount()) {
            return;
        }
        this.totalWinningMoney += winningMoney(sameCount);
        this.winningResults.put(sameCount, this.winningResults.get(sameCount) + 1);
    }

    private int winningMoney(int sameCount) {
        return WinningInfo.valueOfSameCount(sameCount).winningMoney();
    }

    private int compare(int number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
