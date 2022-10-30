package view;

import enums.Match;
import model.LottoPurchaseAmount;
import model.Result;

public class OutputWriter {
    private static final String RESULT_START_MESSAGE = System.lineSeparator() + "당첨 통계";
    private static final String RESULT_START_DELIMETER = "---------";
    private static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT = "%d개 일치 (%d원)- %d개";
    private static final String LOTTO_RESULT_PROFITS = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    public static void printLottoQuantity(int quantity) {
        System.out.println(String.format(PRINT_QUANTITY_FORMAT, quantity));
    }

    public static void printResults(Result result, LottoPurchaseAmount lottoPurchaseAmount) {
        System.out.println(RESULT_START_MESSAGE);
        System.out.println(RESULT_START_DELIMETER);

        for(Match match : Match.values()) {
            int lottoResultCount = result.countLottoResult(match);
            printResult(match, lottoResultCount);
        }

        printProfitRatio(lottoPurchaseAmount, result);
    }

    private static void printResult(Match match, int lottoResultCount) {
        if (!Match.ZERO.equals(match)) {
            System.out.println(String.format(LOTTO_RESULT, match.getCount(), match.getAmount(), lottoResultCount));
        }
    }

    private static void printProfitRatio(LottoPurchaseAmount lottoPurchaseAmount, Result result) {
        System.out.println(String.format(LOTTO_RESULT_PROFITS, lottoPurchaseAmount.findProfitsRatio( result.findTotalProfits() )));
    }

    public static void print(String message) {
        System.out.println(message);
    }
}
