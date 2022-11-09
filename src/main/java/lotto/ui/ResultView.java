package lotto.ui;

import lotto.Lotto;
import lotto.Rank;
import lotto.WinningMatcher;
import lotto.common.Constants;
import lotto.common.LottoAutoUtils;

import java.text.NumberFormat;
import java.util.List;

public class ResultView {
    private StringBuilder sb;

    public ResultView() {
        sb = new StringBuilder();
        sb.append("당첨 통계\n" + "---------\n");
    }

    public String cutDecimal(int cutSize, float value) {
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(cutSize);
        nf.setGroupingUsed(false);

        return nf.format(value);
    }

    public void printBuyLottoCountMessage(int buyLotto, String directInputLotto) {
        System.out.println("수동으로" + directInputLotto.split("\n").length + " 장, " + "자동으로 " + buyLotto + "개를 구매하였습니다.");
    }

    public void printBuyLotto(List<Lotto> lottoList) {
        for (Lotto eachLotto : lottoList) {
            System.out.println(eachLotto.toString());
        }
    }

    public void printWinningStatistics(WinningMatcher winningMatcher) {
        Rank[] ranks = Rank.values();
        for (Rank rank : ranks) {
            printWinningStatisticsMessage(rank, winningMatcher.getMatchNumberMap().value(rank));
        }
    }
    public void printWinningStatisticsMessage(Rank rank, int value) {
        if (rank == Rank.MISS) {
            return;
        }
        if (rank == Rank.SECOND) {
            sb.append(rank.getCountOfMatch() + "개 일치, 보너스 볼 일치(" + rank.getWinningMoney() + "원)-" + value + "개\n");
            return;
        }
        sb.append(rank.getCountOfMatch() + "개 일치(" + rank.getWinningMoney() + "원)-" + value + "개\n");
    }

    public void printProfit(WinningMatcher WinningMatcher, String inputMoney) {
        printProfitMessage(new LottoAutoUtils().stringToNumber(inputMoney), WinningMatcher.getMatchNumberMap().profit());
    }

    public void printProfitMessage(int inputMoney, float profit) {
        System.out.println(sb + "총 수익률은 " + cutDecimal(Constants.DECIMAL_POINT, profit/inputMoney) + "입니다.");
    }
}
