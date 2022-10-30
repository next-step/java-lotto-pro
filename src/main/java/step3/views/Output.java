package step3.views;

import java.util.Map;
import step3.domain.Lottos;
import step3.enums.Message;
import step3.enums.Rank;

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

    public void generateLottos(int count, Lottos lottos) {
        System.out.println(count + Message.COUNT.getMessage());
        lottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getLottoNumber());
        });
    }

    public void statistic(Map<Integer, Integer> statistics, double returnOnInvestmentRate) {
        System.out.println("\n" + Message.STATISTICS.getMessage());
        System.out.println(Message.MATCH_THREE.resultMatchNumber(statistics.get(Rank.FIFTH.getCount())));
        System.out.println(Message.MATCH_FOUR.resultMatchNumber(statistics.get(Rank.FOURTH.getCount())));
        System.out.println(Message.MATCH_FIVE.resultMatchNumber(statistics.get(Rank.THIRD.getCount())));
        System.out.println(Message.MATCH_FIVE_BONUS
                .resultMatchNumber(statistics.get(Rank.THIRD.getCount() + Rank.SECOND.getCount())));
        System.out.println(Message.MATCH_SIX.resultMatchNumber(statistics.get(Rank.FIRST.getCount())));
        System.out.println(Message.STATISTICS_RESULT.resultStatistic(returnOnInvestmentRate));
    }

}
