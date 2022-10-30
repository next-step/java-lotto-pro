package lotto.view;

public class OutputView {
    private static final String PRINT_FORMAT_EARNING_RATIO = "총 수익률은 %.2f입니다.";
    private static final String PRINT_FORMAT_LOSS_RATE = PRINT_FORMAT_EARNING_RATIO + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String OUTPUT_ERROR_MESSAGE_PREFIX = "[ERROR] ";
    public static final String OUTPUT_MESSAGE_WINNING_STATISTICS = "당첨 통계";
    public static final String OUTPUT_MESSAGE_HYPHEN = "---------";
    public static final String ERROR_MESSAGE_MINIMUM_PURCHASE_AMOUNT = "최소 구매 금액은 1000원 입니다.";
    public static final String ERROR_MESSAGE_AMOUNT_UNIT_OF_1000 = "1000 단위로 입력해주세요.";
    public static final String ERROR_MESSAGE_INPUT_AMOUNT_ONLY_NUMBER = "숫자를 입력해주세요.";
    public static final String ERROR_MESSAGE_INPUT_AMOUNT_EXCESS = "최대 구매 금액을 초과했습니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBER_1_TO_45 = "로또 번호는 1 ~ 45 사이의 숫자입니다.";
    public static final String ERROR_MESSAGE_LOTTO_NUMBERS_SIZE_IS_6 = "로또 번호는 6개 입니다.";
    public static final String ERROR_MESSAGE_INPUT_MANUAL_LOTTO_NUMBER = "잘못된 입력입니다. 숫자와 ,를 사용해 입력해주세요.";
    public static final String ERROR_MESSAGE_INPUT_MANUAL_NUMBER_DUPLICATE = "중복 된 숫자가 있습니다.";

    private OutputView() {
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void error(String message) {
        println(OUTPUT_ERROR_MESSAGE_PREFIX + message);
    }

    public static void printStatistics(String statistics) {
        printNewLine();
        println(OUTPUT_MESSAGE_WINNING_STATISTICS);
        println(OUTPUT_MESSAGE_HYPHEN);
        print(statistics);
    }

    public static void printEarningRatio(double earningRatio) {
        String rateFormat = isLossRate(earningRatio) ? PRINT_FORMAT_LOSS_RATE : PRINT_FORMAT_EARNING_RATIO;
        System.out.printf(rateFormat, earningRatio);
    }

    private static boolean isLossRate(double earningRatio) {
        return earningRatio < 1;
    }
}
