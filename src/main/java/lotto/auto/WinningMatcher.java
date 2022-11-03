package lotto.auto;

import lotto.auto.common.LottoAutoUtils;
import lotto.auto.ui.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.auto.common.Constants.INIT_NUM;

public class WinningMatcher {
    private ResultView resultView;
    private MatchNumberMap matchNumberMap;

    public WinningMatcher(Buyer buyer, LottoNumbers lottoNumbers) {
        resultView = new ResultView();
        this.matchNumberMap = matchWinningNumbers(buyer.getLottos(), lottoNumbers);
    }

    private MatchNumberMap matchWinningNumbers(List<Lotto> lottoList, LottoNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();  // (하나의 로또에서 일치한 수, 일치한 로또의 개수)

        for (Lotto lotto : lottoList) {
            int cnt = countMatchNumber(lotto, winningNumbers);
            makeResult(result, cnt);
        }
        return new MatchNumberMap(result);
    }

    private void makeResult(Map<Rank, Integer> result, int cnt) {
        Rank rank = Rank.valueOf(cnt);
        if (rank != null && result.containsKey(rank)) {
            result.put(rank, result.get(rank) + 1);
        }
        result.put(rank, 1);
    }

    private int countMatchNumber(Lotto lotto, LottoNumbers winningNumbers) {
        int cnt = INIT_NUM;
        for (int num: lotto.getLottoNumbers()) {
            cnt += isMatched(num, winningNumbers);
        }

        return cnt;
    }

    private int isMatched(int num, LottoNumbers winningNumbers) {
        if (winningNumbers.getNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }

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
