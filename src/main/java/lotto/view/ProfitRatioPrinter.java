package lotto.view;

public class ProfitRatioPrinter {
    private static final String PROFILE_RATIO_MESSAGE = "총 수익률은 ";
    private static final String FORMAL_SENTENCE_POSTFIX = "입니다.";

    public static void print(String profitRatioString) {
        System.out.println(PROFILE_RATIO_MESSAGE + profitRatioString + FORMAL_SENTENCE_POSTFIX);
    }
}
