package lotto.ui;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningRank;

import java.util.List;
import java.util.Map;

public class ResultView {

    public void printLottoCount(LottoPrice lottoPrice) {
        System.out.println(lottoPrice.getCount() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.print(lottoNumber.getNumbers());
            System.out.println(" 보너스볼: " + lottoNumber.getBonusNumber());
        }
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        printStatisticsInit();
        printLottoMatch(lottoStatistics);
        printLottoProfit(lottoStatistics);
    }

    private void printStatisticsInit() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void printLottoMatch(LottoStatistics lottoStatistics) {
        Map<WinningRank, Integer> countByWinningRank = lottoStatistics.getCountByWinningRank();
        for (WinningRank value : WinningRank.getPrintWinningRanks()) {
            Integer count = countByWinningRank.getOrDefault(value, 0);
            System.out.println(value.matchCount + "개 일치" + printBonusInfo(value) + "(" + value.price + ") - " + count + "개");
        }
    }

    private void printLottoProfit(LottoStatistics lottoStatistics) {
        double profit = lottoStatistics.calculateProfit();
        System.out.print("총 수익률은 " + profit + "입니다.");
        if (profit < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
        }
    }

    private String printBonusInfo(WinningRank value) {
        if (Boolean.TRUE.equals(value.matchedBonus)) {
            return ", 보너스 볼 일치";
        }
        return " ";
    }
}
