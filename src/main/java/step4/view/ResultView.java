package step4.view;

import step4.model.LottoResult;
import step4.service.LottoScoreType;

import java.util.Arrays;

public class ResultView {

    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String RESULT_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";

    public void printLottoResult(LottoResult lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoScoreType.values()).forEach(scoreType -> {
            int score = scoreType.getScore();
            int matchedCount = lottoResults.getByLottoScoreType(scoreType);
            int money = scoreType.getMoney();

            String result = String.format(RESULT_FORMAT, score, money, matchedCount);
            if (LottoScoreType.FIVE_BONUS.equals(scoreType)) {
                result = String.format(RESULT_BONUS_FORMAT, score, money, matchedCount);
            }

            System.out.println(result);
        });
    }

    public void printRate(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
