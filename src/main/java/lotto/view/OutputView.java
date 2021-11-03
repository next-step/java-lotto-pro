package lotto.view;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import static lotto.domain.Rank.*;

public class OutputView {

    private static final DecimalFormat amountFormatter = new DecimalFormat("###,###");
    private OutputView() {

    }

    public static void printLottoCount(int countOfLotto) {
        System.out.println(countOfLotto + "개를 구매했습니다.");
    }

    public static void printLotto(List<List<Integer>> lottos) {
        StringBuilder output = new StringBuilder();
        for (List<Integer> lotto : lottos) {
            output.append("[");
            lotto.stream()
                    .forEach(number -> output.append(number + ", "));
            output.delete(output.length() - 2, output.length());
            output.append("]\n");
        }
        System.out.println(output);
    }

    public static void printResult(Map<Rank, Integer> result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("--------------");
        int totalPrizeMoney = 0;
        for (Rank findRank : Rank.getLottoResultRank()) {
            int lottoResultCount = calculateLottoResultCount(result, findRank);
            int winMoney = findRank.winMoney();
            totalPrizeMoney += winMoney * lottoResultCount;
            System.out.println(findRank.count() + "개 일치 (" + amountFormatter.format(winMoney) + "원)- " + lottoResultCount + "개");
        }
        float earningRate = calculateEarnningRate(totalPrizeMoney, purchaseAmount);
        System.out.printf("총 수익률은 %.2f 입니다.", earningRate);
    }

    private static float calculateEarnningRate(int totalPrizeMoney, int purchaseAmount) {
        return (float) totalPrizeMoney / purchaseAmount;
    }

    private static int calculateLottoResultCount(Map<Rank, Integer> result, Rank findRank) {
        if (result.get(findRank) == null) {
            return 0;
        }
        return result.get(findRank);
    }
}
