package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Organizer {
    private static final int INIT_RESULT_COUNT = 0;

    private final Lotto winningLotto;
    private final LottoNo bonusLottoNo;
    private Map<Rank, Integer> winningResults;
    private long totalWinningMoney;

    public Organizer(Lotto winningLotto, LottoNo bonusLottoNo) {
        this.winningLotto = winningLotto;
        this.bonusLottoNo = checkBonusNumber(bonusLottoNo, winningLotto);
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
        return lotto.contain(this.bonusLottoNo);
    }

    private int userNumberSameCount(Lotto lotto) {
        return (int) lotto.seeNumbers().stream()
                .filter(this::compare)
                .count();
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

    private boolean compare(LottoNo number) {
        return this.winningLotto.contain(number);
    }

    private LottoNo checkBonusNumber(LottoNo bonusLottoNo, Lotto winningLotto) {
        if (winningLotto.contain(bonusLottoNo)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 달라야합니다.");
        }
        return bonusLottoNo;
    }
}
