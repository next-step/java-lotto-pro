package lotto.auto;

import lotto.auto.ui.InputView;
import lotto.auto.ui.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinyMatch {

    public void start() {
        InputView inputView = new InputView();
        String inputMoney = inputView.getInputString();
        Buyer buyer = new Buyer(inputMoney);
        buyer.buyLotto();

        inputView.printLotto(buyer.getLotto());
        LottoNumbers winningNumbers = new LottoNumbers(inputView.getInputWinningNubers());

        ResultView resultView = new ResultView();
        resultView.printResult(inputMoney, matchWinningNumbers(buyer.getLotto(), winningNumbers));
    }

    private Map<Integer, Integer> matchWinningNumbers(List<Lotto> lottoList, LottoNumbers winningNumbers) {
        Map<Integer, Integer> result = new HashMap<>();  // (하나의 로또에서 일치한 수, 일치한 로또의 개수)
        for (Lotto lotto : lottoList) {
            int cnt = countMatchNumber(lotto, winningNumbers);
            makeResult(result, cnt);
        }
        return result;
    }

    private void makeResult(Map<Integer, Integer> result, int cnt) {
        if (result.containsKey(cnt)) {
            result.put(cnt, result.get(cnt) + 1);
        }
        result.put(cnt, 1);
    }

    private int countMatchNumber(Lotto lotto, LottoNumbers winningNumbers) {
        int cnt = 0;
        for (int num: lotto.getLottoNumbers()) {
            cnt += isMatched(num, winningNumbers);
        }

        return cnt;
    }

    private int isMatched(int num, LottoNumbers winningNumbers) {
        if (winningNumbers.getLottoNumbers().contains(num)) {
            return 1;
        }
        return 0;
    }
}
