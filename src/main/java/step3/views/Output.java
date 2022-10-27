package step3.views;

import java.util.List;
import java.util.Map;
import step3.domain.Lotto;
import step3.enums.Award;
import step3.enums.Message;

public class Output {

    public void purchase() {
        System.out.println(Message.START.getMessage());
    }

    public void winnerNumbers() {
        System.out.println("\n" + Message.WIN_NUMBERS.getMessage());
    }

    public void bonusball() {
        System.out.println(Message.BONUS.getMessage());
    }

    public void generateLottos(int count, List<Lotto> lottos) {
        System.out.println(count + Message.COUNT.getMessage());
        lottos.forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers());
        });
    }

    public void statistic(Map<Integer, Integer> statistics, double returnOnInvestmentRate) {
        System.out.println("\n" + Message.STATISTICS.getMessage());
        System.out.println(Message.MATCH_THREE.resultMatchNumber(statistics.get(Award.THREE.getCount())));
        System.out.println(Message.MATCH_FOUR.resultMatchNumber(statistics.get(Award.FOUR.getCount())));
        System.out.println(Message.MATCH_FIVE.resultMatchNumber(statistics.get(Award.FIVE.getCount())));
        System.out.println(Message.MATCH_FIVE_BONUS.resultMatchNumber(statistics.get(Award.FIVE_BONUS.getCount())));
        System.out.println(Message.MATCH_SIX.resultMatchNumber(statistics.get(Award.SIX.getCount())));
        System.out.println(Message.STATISTICS_RESULT.resultStatistic(returnOnInvestmentRate));
    }

}
