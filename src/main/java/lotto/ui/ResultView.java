package lotto.ui;

import lotto.domain.Result;

public class ResultView {

    public static void printPlayslips(final int numberOfPlayslips, final String playslips) {
        System.out.println(numberOfPlayslips + "개를 구매했습니다.");
        System.out.println(playslips);
    }

    public static void printStats(Result result) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println("3 개 일치 ("
            + Result.FOURTH_PRIZE.asString()
            + " 원)- "
            + result.getMatchedThreeNumbers()
            + "개"
        );
        System.out.println(
            "4 개 일치 ("
                + Result.THIRD_PRIZE.asString()
                + " 원)- "
                + result.getMatchedFourNumbers()
                + "개"
        );
        System.out.println(
            "5 개 일치 ("
                + Result.SECOND_PRIZE.asString()
                + " 원)- "
                + result.getMatchedFiveNumbers()
                + "개"
        );
        System.out.println(
            "6 개 일치 ("
                + Result.FIRST_PRIZE.asString()
                + " 원)- "
                + result.getMatchedSixNumbers()
                + "개"
        );
        System.out.println("총 수익률은 " + result.calculateReturnOnInvestment() + " 입니다.");
    }
}
