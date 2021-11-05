package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.LottoNumbers;

import java.util.List;

public class ResultView {

    private static final int LOTTO_SIZE = 6;
    private static int[] lottoResult = new int[LOTTO_SIZE + 1];
    private static int PRINT_COUNT = 4;
    private static int[] WINNING_AMOUNT = {5000, 50000, 1500000, 2000000000};

    private static final LottoController lottoController = new LottoController();

    public static void start(List<LottoNumbers> lottoNumbersList, LottoNumbers winningNumbers) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (LottoNumbers lottoNumbers : lottoNumbersList) {
            int count = lottoController.countWinningNumber(winningNumbers, lottoNumbers);
            lottoResult[count]++;
        }

        printWinningResult(lottoNumbersList.size());
    }

    private static void printWinningResult(int purchaseCount) {
        int priceIndex = 0;
        int winningPriceSum = 0;
        for (int i = lottoResult.length - PRINT_COUNT; i < lottoResult.length; i++) {
            System.out.println(i + "개 일치 (" + WINNING_AMOUNT[priceIndex] + "원)- " + lottoResult[i] + "개");
            winningPriceSum += getWinningPrice(priceIndex, i);
            priceIndex++;
        }

        double rateOfReturn = lottoController.getRateOfReturn(purchaseCount, winningPriceSum);
        System.out.printf("총 수익률은 " + Math.floor((rateOfReturn * 100)) / 100.0 + "입니다.");
        System.out.println("(기준이 1이기 때문에 결과적으로 " + getResult(rateOfReturn) + "(이)라는 의미임)");
    }

    private static int getWinningPrice(int priceIndex, int i) {
        if (lottoResult[i] > 0) {
            return WINNING_AMOUNT[priceIndex];
        }
        return 0;
    }

    private static String getResult(double rateOfReturn) {
        if (rateOfReturn > 1) {
            return "이익";
        }
        if (rateOfReturn < 1) {
            return "손해";
        }
        return "본전";
    }
}
