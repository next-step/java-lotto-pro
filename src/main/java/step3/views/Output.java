package step3.views;

import java.util.List;
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

    public void manualCount() {
        System.out.println(Message.MANUAL_COUNT.getMessage());
    }

    public void manualNumber() {
        System.out.println(Message.MANUAL_NUMBER.getMessage());
    }

    public void generateLottos(int count, Lottos totalLottos, Lottos manualLottos) {
        int manualLottosCnt = manualLottos.getLottos().size();
        System.out.println(count + Message.resultMatchNumber(manualLottosCnt, count-manualLottosCnt ));
        totalLottos.getLottos().forEach(lotto -> {
            System.out.println(lotto.getLottoNumbers());
        });
    }

    public void statistics (double returnOnInvestmentRate) {
        System.out.println("\n" + Message.STATISTICS.getMessage());
        System.out.println(Message.MATCH_THREE.resultMatchNumber(Rank.FIFTH.getLottoMatcher().lottoCount()));
        System.out.println(Message.MATCH_FOUR.resultMatchNumber(Rank.FOURTH.getLottoMatcher().lottoCount()));
        System.out.println(Message.MATCH_FIVE.resultMatchNumber(Rank.THIRD.getLottoMatcher().lottoCount()));
        System.out.println(Message.MATCH_FIVE_BONUS
                .resultMatchNumber(Rank.SECOND.getLottoMatcher().lottoCount()));
        System.out.println(Message.MATCH_SIX.resultMatchNumber(Rank.FIRST.getLottoMatcher().lottoCount()));
        System.out.println(Message.STATISTICS_RESULT.resultStatistic(returnOnInvestmentRate));
    }

}
