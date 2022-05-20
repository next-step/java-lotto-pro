package lotto.model;

import java.util.*;
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
        return String.format("%.2f", Math.floor((double) this.totalWinningMoney / buyAmount * 100) / 100);
    }

    private void initWinningResult() {
        this.winningResults = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningResults.put(rank.sameCount(), INIT_RESULT_COUNT);
        }
    }

    private void countWinning(int sameCount) {
        if (sameCount < Rank.FIFTH.sameCount()) {
            return;
        }
        Optional<Rank> winningRank = Rank.matchCountOf(sameCount);
        if (winningRank.isPresent()) {
            this.totalWinningMoney += winningRank.get().winningMoney();
            this.winningResults.put(sameCount, this.winningResults.get(sameCount) + 1);
        }

    }

    private int compare(int number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
