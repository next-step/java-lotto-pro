package step3.view;

import step3.model.LottoResult;
import step3.model.LottoResults;

public class ResultView {

    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";

    public void printLottoResult(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        int resultCount = lottoResults.count();
        for (int index = 0 ; index < resultCount ; index++) {
            LottoResult lottoResult = lottoResults.getResultByIndex(index);
            int score = lottoResult.getScore();
            int money = lottoResult.getMoney();
            int scoreMatchedCount = lottoResult.getScoreMatchedCount();

            String result = String.format(RESULT_FORMAT, score, money, scoreMatchedCount);
            System.out.println(result);
        }
    }

    public void printRate(double rate) {
        System.out.println("총 수익률은 " + rate + "입니다.");
    }
}
