package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String QUANTITY_PRINT_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String DELIMITER = ", ";
    private static final String LOTTO_MESSAGE_START_CHAR = "[";
    private static final String LOTTO_MESSAGE_END_CHAR = "]";
    private static final String PROFIT_MESSAGE_FORMAT = "총 수익률은 %.2f입니다.";
    private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String RESULT_MESSAGE_FORMAT = "%d개 일치 (%d원)- %d개";

    public static void printLottos(Lottos lottos) {
        printQuantity(lottos.getQuantity());
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    private static void printQuantity(int quantity) {
        String message = String.format(QUANTITY_PRINT_MESSAGE_FORMAT, quantity);
        System.out.println(message);
    }

    private static void printLotto(Lotto lotto) {
        List<String> stringNumbers = lotto.getNumbers().stream().map(Object::toString).collect(Collectors.toList());
        String lottoMessage = LOTTO_MESSAGE_START_CHAR + String.join(DELIMITER, stringNumbers) + LOTTO_MESSAGE_END_CHAR;
        System.out.println(lottoMessage);
    }

    public static void printResults(List<Result> results) {
        printResult(results, Result.WINNER);
        printResult(results, Result.SECOND);
        printResult(results, Result.THIRD);
        printResult(results, Result.FOURTH);
    }

    private static void printResult(List<Result> results, Result printTarget) {
        int count = 0;
        for (final Result result : results) {
            count = plusCountIfEquals(printTarget, count, result);
        }
        String message = String.format(RESULT_MESSAGE_FORMAT, printTarget.getContainsCount(),
            printTarget.getPrizeMoney(), count);
        System.out.println(message);
    }

    private static int plusCountIfEquals(Result printTarget, int count, Result result) {
        if (printTarget.equals(result)) {
            count++;
        }
        return count;
    }

    public static void printProfit(double profit) {
        String message = String.format(PROFIT_MESSAGE_FORMAT, profit);
        System.out.print(message);
        if (profit < 1) {
            System.out.println(LOSS_MESSAGE);
        }
    }
}
