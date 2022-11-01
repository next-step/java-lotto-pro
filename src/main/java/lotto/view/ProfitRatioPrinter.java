package lotto.view;

import java.text.DecimalFormat;

public class ProfitRatioPrinter {
    private static final String PROFILE_RATIO_MESSAGE = "총 수익률은 ";
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    private static final String FORMAL_SENTENCE_POSTFIX = "입니다.";

    public static void print(double profitRatio) {
        System.out.println(PROFILE_RATIO_MESSAGE + decimalFormat.format(profitRatio) + FORMAL_SENTENCE_POSTFIX);
    }
}
