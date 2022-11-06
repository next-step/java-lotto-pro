package lotto;

import lotto.common.LottoAutoUtils;
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

    // TODO
    public void printWinningStatistics() {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            resultView.printWinningStatisticsMessage(rank, matchNumberMap.value(rank));
        }
    }

    public void printProfit(String inputMoney) {
        resultView.printProfitMessage(new LottoAutoUtils().stringToNumber(inputMoney), matchNumberMap.profit());
    }
}
