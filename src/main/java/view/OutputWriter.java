package view;

import enums.Match;
import model.LottoPurchaseAmount;
import model.Result;

import static enums.Match.*;

public class OutputWriter {
    private static final String RESULT_START_MESSAGE = System.lineSeparator() + "당첨 통계";
    private static final String RESULT_START_DELIMETER = "---------";
    private static final String PRINT_AUTO_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String PRINT_AUTO_MAUNAL_QUANTITY_FORMAT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String PRINT_QUANTITY_FORMAT = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT = "%d개 일치 (%d원)- %d개";

    private static final String LOTTO_RESULT_CONTAIN_BONUS = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
    private static final String LOTTO_RESULT_PROFITS = "총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)";

    private static final String INQUIRE_MANUAL_LOTTO_NUMBERS_MESSAGE = System.lineSeparator() + "수동으로 구매할 번호를 입력해 주세요.";

    public static void printLottoQuantity(int quantity) {
        System.out.println(String.format(PRINT_AUTO_QUANTITY_FORMAT, quantity));
    }

    public static void printLottoQuantity(String autoQuantity, int manualQuantity) {
        System.out.println(String.format(PRINT_AUTO_MAUNAL_QUANTITY_FORMAT, Integer.parseInt(autoQuantity), manualQuantity));
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
        String printLottoMatchFomat = LOTTO_RESULT;
        if ( match == SECOND ) {
            printLottoMatchFomat = LOTTO_RESULT_CONTAIN_BONUS;
        }

        if ( match != ZERO ) {
            System.out.println(String.format(printLottoMatchFomat, match.getCount(), match.getAmount(), lottoResultCount));
        }
    }

    private static void printProfitRatio(LottoPurchaseAmount lottoPurchaseAmount, Result result) {
        System.out.println(String.format(LOTTO_RESULT_PROFITS, lottoPurchaseAmount.findProfitsRatio( result.findTotalProfits() )));
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printInquireManualLottoNumbersDirection() {
        System.out.println(INQUIRE_MANUAL_LOTTO_NUMBERS_MESSAGE);
    }
}
