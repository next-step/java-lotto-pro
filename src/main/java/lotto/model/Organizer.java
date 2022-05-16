package lotto.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Organizer {
    private static final int COMPARE_TRUE = 1;
    private static final int COMPARE_FALSE = 0;
    private static final int SAME_COUNT_3 = 3;
    private static final int SAME_COUNT_4 = 4;
    private static final int SAME_COUNT_5 = 5;
    private static final int SAME_COUNT_6 = 6;
    private static final int INIT_RESULT_COUNT = 0;

    private final List<Integer> winnerNumbers;
    private Map<Integer, Integer> winningResults;

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

    private void initWinningResult() {
        this.winningResults = new HashMap<>();
        winningResults.put(SAME_COUNT_3, INIT_RESULT_COUNT);
        winningResults.put(SAME_COUNT_4, INIT_RESULT_COUNT);
        winningResults.put(SAME_COUNT_5, INIT_RESULT_COUNT);
        winningResults.put(SAME_COUNT_6, INIT_RESULT_COUNT);
    }

    private void countWinning(int sameCount) {
        if (sameCount < SAME_COUNT_3) {
            return;
        }
        this.winningResults.put(sameCount, this.winningResults.get(sameCount) + 1);
    }

    public static int winningMoney(int sameCount) {
        switch (sameCount) {
            case SAME_COUNT_3:
                return 5000;
            case SAME_COUNT_4:
                return 50000;
            case SAME_COUNT_5:
                return 1500000;
            case SAME_COUNT_6:
                return 2000000000;
            default:
                return 0;
        }
    }

    private int compare(int number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
