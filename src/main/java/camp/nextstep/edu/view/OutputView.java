package camp.nextstep.edu.view;

import camp.nextstep.edu.level1.lotto.lotto.Lotto;
import camp.nextstep.edu.level1.lotto.lotto.LottoResult;
import camp.nextstep.edu.level1.stringCaluator.calculator.StringCalculator;

public class OutputView {
    private OutputView() {}

    public static void showCalculateResult(StringCalculator calculator) {
        System.out.println("계산 결과는 " + calculator.sum() + " 입니다.");
    }

    public static void showLottoResultStatistics(Lotto lotto, LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoResult.toString());
        System.out.println(earnRateMessage(lotto, lottoResult));
    }

    private static String earnRateMessage(Lotto lotto, LottoResult lottoResult) {
        StringBuilder message = new StringBuilder();
        double earnRate = lotto.calculateReturnValue(lottoResult.winningAmount());

        message.append("총 수익률은 ")
                .append(earnRate)
                .append("입니다.(기준이 1이기 떄문에 결과적으로 ")
                .append(getLossOrEarnMessage(earnRate))
                .append("라는 의미임");

        return message.toString();
    }

    private static String getLossOrEarnMessage(double earnRate) {
        if (earnRate < 1) {
            return "손해";
        }
        return "이득";
    }
}
