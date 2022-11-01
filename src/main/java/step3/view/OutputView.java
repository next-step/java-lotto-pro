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
        System.out.printf("총 수익률은 %.2f입니다.",statisticResult);
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
        results.createStringOutput().stream().map(s->s.split(Rule.DELIMITER))
                .forEach(OutputView::printResultDetail);
    }

    private static void printResultDetail(String[] s) {
        int matchCount = Integer.parseInt(s[0]);
        int bonusCount = Integer.parseInt(s[1]);
        String prize = s[2];
        String matchQuantity = s[3];
        if(matchCount==Rule.BONUS_COUNT_NUMBER && bonusCount>0){
            System.out.printf("%d개 일치, 보너스 볼 일치(%s원) - %s개%n", matchCount, prize, matchQuantity);
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %s개%n", matchCount, prize, matchQuantity);
    }

    public static void printOrder(Order order) {
        System.out.println(order+"개를 구매했습니다.");
    }
}
