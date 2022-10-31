package step3.view;

import java.util.List;
import step3.model.lotto.LottoList;
import step3.model.machine.Order;
import step3.model.machine.Results;
import step3.model.value.Rule;

public class OutputView {

    // 인스턴스화 방지
    private OutputView() {
        throw new AssertionError();
    }

    public static void printStatisticResult(double statisticResult) {
        System.out.println(String.format("총 수익률은 %.2f입니다.",statisticResult));
    }

    public static void printTickets(LottoList lottoList) {
        List<String> lottoListString = lottoList.getLottoListString();
        for(String lotto: lottoListString){
            System.out.println(lotto);
        }
    }

    public static void printResults(Results results) {
        System.out.println("당첨 통계");
        System.out.println("___________");
        results.createStringOutput().stream().map(s->s.split(Rule.DELIMITER)).forEach(
                s -> System.out.println(String.format("%s개 일치 (%s원) - %s개",(Object[])s)
        ));
    }

    public static void printOrder(Order order) {
        System.out.println(order.toString());
    }
}
