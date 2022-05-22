package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Organizer {
    private static final int COMPARE_TRUE = 1;
    private static final int COMPARE_FALSE = 0;
    private static final int INIT_RESULT_COUNT = 0;

    private final WinningNumber winnerNumbers;
    private final BonusNumber bonusNumber;
    private Map<Rank, Integer> winningResults;
    private long totalWinningMoney;

    public Organizer(WinningNumber winningNumbers, BonusNumber bonusNumber) {
        this.winnerNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> winningResults(Lottos lottos) {
        initWinningResult();
        for (Lotto lotto : lottos.allGames()) {
            countWinning(userNumberSameCount(lotto), sameBonusNumber(lotto));
        }
        return winningResults;
    }

    public String winningRate(int buyAmount) {
        return String.format("%.2f", Math.floor((double) this.totalWinningMoney / buyAmount * 100) / 100);
    }

    private boolean sameBonusNumber(Lotto lotto) {
        return lotto.contain(this.bonusNumber.value());
    }

    private int userNumberSameCount(Lotto lotto) {
        int sameCount = 0;
        for (LottoNo lottoNo : lotto.seeNumbers()) {
            sameCount += compare(lottoNo);
        }
        return sameCount;
    }

    private void initWinningResult() {
        this.winningResults = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            winningResults.put(rank, INIT_RESULT_COUNT);
        }
    }

    private void countWinning(int sameCount, boolean sameBonusNumber) {
        if (sameCount < Rank.FIFTH.sameCount()) {
            return;
        }
        Rank winningRank = Rank.matchCountOf(sameCount, sameBonusNumber);
        this.totalWinningMoney += winningRank.winningMoney();
        this.winningResults.put(winningRank, this.winningResults.get(winningRank) + 1);
    }

    private int compare(LottoNo number) {
        return this.winnerNumbers.contains(number) ? COMPARE_TRUE : COMPARE_FALSE;
    }
}
