package lotto.view;

import lotto.domain.Rank;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final DecimalFormat AMOUNT_FORMATTER = new DecimalFormat("###,###");

    private OutputView() {

    }

    public static void printLottoCount(int countOfManualLotto , int countOfAutoLotto) {
        System.out.println("수동으로 " + countOfManualLotto+"장, 자동으로 "+ (countOfAutoLotto - countOfManualLotto)  + "개를 구매했습니다.");
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

    public static void printLotto(String lottoInfo) {
        System.out.println(lottoInfo);
    }

    public static void printResult(Map<Rank, Integer> result, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("--------------");
        int totalPrizeMoney = 0;
        for (Rank findRank : Rank.getLottoResultRank()) {
            int lottoResultCount = calculateLottoResultCount(result, findRank);
            int winMoney = findRank.winMoney();
            totalPrizeMoney += winMoney * lottoResultCount;
            System.out.println(printLottoRankResult(findRank, lottoResultCount, winMoney));
        }
        float earningRate = calculateEarnningRate(totalPrizeMoney, purchaseAmount);
        System.out.printf("총 수익률은 %.2f 입니다.", earningRate);
    }

    private static String printLottoRankResult(Rank findRank, int lottoResultCount, int winMoney) {
        if (isSecondRank(findRank)) {
            return (findRank.count() + "개 일치 ,보너스볼 일치 (" + AMOUNT_FORMATTER.format(winMoney) + "원)- " + lottoResultCount + "개");
        }
        return (findRank.count() + "개 일치 (" + AMOUNT_FORMATTER.format(winMoney) + "원)- " + lottoResultCount + "개");
    }

    private static boolean isSecondRank(Rank findRank) {
        return Rank.SECOND == findRank;
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
