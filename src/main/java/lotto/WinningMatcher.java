package lotto;

import lotto.ui.ResultView;

import java.util.List;

public class WinningMatcher {
    private ResultView resultView;
    private MatchNumberMap matchNumberMap;

    public WinningMatcher(Buyer buyer, WinningLotto winningLotto) {
        matchNumberMap = new MatchNumberMap();
        resultView = new ResultView();
        matchWinningNumbers(buyer.getLottos(), winningLotto);
    }

    private void matchWinningNumbers(List<Lotto> lottoList, WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            makeResult(winningLotto.match(lotto), winningLotto.isMatchBonusNumber(lotto));
        }
    }

    private void makeResult(int cnt, boolean isMatchBonusNumber) {
        Rank rank = Rank.valueOf(cnt, isMatchBonusNumber);
        this.matchNumberMap.put(rank, this.matchNumberMap.get(rank) + 1);
    }

    public MatchNumberMap getMatchNumberMap() {
        return matchNumberMap;
    }
}
