package step3.io;

import java.util.List;
import step3.domain.Lottos;
import step3.domain.Money;

public class OutputView {

    public void printPurchaseCount(Money payment, Money pricePerLotto) {
        System.out.println(payment.getPurchaseCount(pricePerLotto) + "개를 구매했습니다.");
    }

    public void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printResultHeader() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public void printStatistics(List<String> statistics) {
        statistics.forEach(System.out::println);
    }

    public void printWinningMoneyRate(String winningMoneyRate) {
        System.out.println("총 수익률은 " + winningMoneyRate + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
    }
}
