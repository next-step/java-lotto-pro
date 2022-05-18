package lotto.ui;

import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoStatistics;
import lotto.domain.WinningRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultView {

    public void printLottoCount(LottoCount lottoCount) {
        System.out.println("\n수동으로 " + lottoCount.getManualCount() + "장, 자동으로 " + lottoCount.getAutoCount() + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(convertToSortedList(lottoNumber));
        }
    }

    public void printStatistics(LottoStatistics lottoStatistics) {
        printStatisticsInit();
        printLottoMatch(lottoStatistics);
        printLottoProfit(lottoStatistics);
    }

    private ArrayList<Integer> convertToSortedList(LottoNumbers lottoNumber) {
        ArrayList<Integer> arrayNumbers = new ArrayList<>(lottoNumber.getNumbers());
        arrayNumbers.sort(Integer::compareTo);
        return arrayNumbers;
    }

    private void printStatisticsInit() {
        System.out.println();
        System.out.println("\n당첨 통계");
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
