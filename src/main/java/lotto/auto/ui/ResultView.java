package lotto.auto.ui;

import lotto.auto.Rank;
import lotto.auto.common.LottoAutoUtils;

import java.text.NumberFormat;
import java.util.Map;

import static lotto.auto.common.Constants.LOTTO_LENGTH;
import static lotto.auto.common.Constants.NUMBER_OF_MINIMUM_WINNING;

public class ResultView {

    public ResultView() {
    }

    public void printResult(String inputMoney, Map<Integer, Integer> matchWinningNumbers) {
        float profit = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n" + "---------\n");

        for (int i = NUMBER_OF_MINIMUM_WINNING; i <= LOTTO_LENGTH; i++) {
            int cnt = getMatchCount(matchWinningNumbers, i);
            sb.append(i + "개 일치(" + Rank.getRank(i) + ")-" + cnt + "개\n");
            profit = profit + Rank.getMoney(i, cnt);
        }
        if (profit > 0) {
            profit = profit / new LottoAutoUtils().stringToNumber(inputMoney);
        }
        System.out.println(sb + "총 수익률은 " + cutDecimal(2, profit) + "입니다.");
    }

    private int getMatchCount(Map<Integer, Integer> matchWinningNumbers, int numberOfMatched) {
        if (matchWinningNumbers.containsKey(numberOfMatched)) {
            return matchWinningNumbers.get(numberOfMatched);
        }
        return 0;
    }

    public String cutDecimal(int cutSize, double value) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(cutSize);
        nf.setGroupingUsed(false);

        return nf.format(value);
    }
}
