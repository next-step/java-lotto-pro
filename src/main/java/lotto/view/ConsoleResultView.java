package lotto.view;

import lotto.LottoPrize;
import lotto.WinningResult;
import lotto.lotto.Lotto;
import lotto.money.Money;
import java.util.List;
import static java.util.Objects.requireNonNull;

class ConsoleResultView implements ResultView {

    @Override
    public void printLottoes(List<Lotto> lottoes) {
        requireNonNull(lottoes, "lottoes");
        System.out.printf("%d개를 구매했습니다.%n", lottoes.size());
        printLottoesInformation(lottoes);
    }

    @Override
    public void printResult(WinningResult winningResult, Money money) {
        requireNonNull(winningResult, "winningResult");
        requireNonNull(money, "money");
        printHeaderOfResult();
        printResult(winningResult);
        printRateOfReturn(winningResult, money);
    }

    private static void printLottoesInformation(List<Lotto> lottoes) {
        for (Lotto lotto : lottoes) {
            System.out.println(lotto);
        }
    }

    private static  void printHeaderOfResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private static void printResult(WinningResult winningResult) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            final Integer count = winningResult.find(lottoPrize);
            System.out.printf("%s (%s원)- %s개%n", lottoPrize.description(), lottoPrize.prize(), count);
        }
    }

    private static void printRateOfReturn(WinningResult winningResult, Money money) {
        System.out.printf("총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n",
                          winningResult.rateOfReturn(money));
    }
}
