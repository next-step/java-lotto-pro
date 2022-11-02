package lotto.auto.ui;

import lotto.auto.Lotto;
import lotto.auto.Rank;

import java.text.NumberFormat;
import java.util.List;

public class ResultView {
    private static final int DECIMAL_POINT = 2;

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

    public void printBuyLottoCountMessage(int buyLotto) {
        System.out.println(buyLotto + "개를 구매하였습니다.");
    }

    public void printBuyLotto(List<Lotto> lottoList) {
        for (Lotto eachLotto : lottoList) {
            System.out.println(eachLotto.toString());
        }
    }

    public void printWinningStatisticsMessage(Rank rank, int value) {
        sb.append(rank.getCountOfMatch() + "개 일치(" + rank.getWinningMoney() + ")-" + value + "개\n");
    }

    public void printProfitMessage(int inputMoney, float profit) {
        System.out.println(sb + "총 수익률은 " + cutDecimal(DECIMAL_POINT, profit/inputMoney) + "입니다.");
    }
}
