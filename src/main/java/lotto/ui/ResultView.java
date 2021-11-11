package lotto.ui;

import lotto.domain.PickedNumbers;
import lotto.domain.Playslips;
import lotto.domain.Result;

public class ResultView {

    public static void printStats(
        final Playslips playslips,
        final PickedNumbers pastWinningNumbers
    ) {
        final Result result = playslips.checkResult(pastWinningNumbers);

        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(
            "3 개 일치 (" + Result.FOURTH_PRIZE + " 원)- " + result.getMatchedThreeNumbers() + "개"
        );
        System.out.println(
            "4 개 일치 (" + Result.THIRD_PRIZE + " 원)- " + result.getMatchedFourNumbers() + "개"
        );
        System.out.println(
            "5 개 일치 (" + Result.SECOND_PRIZE + " 원)- " + result.getMatchedFiveNumbers() + "개"
        );
        System.out.println(
            "6 개 일치 (" + Result.FIRST_PRIZE + " 원)- " + result.getMatchedSixNumbers() + "개"
        );
        System.out.println("총 수익률은 " + result.calculateReturnOnInvestment() + " 입니다.");
    }
}
