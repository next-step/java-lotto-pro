package step3.view;

import step3.LottoResult;

import java.util.List;

public class ResultView {

    private static final String RESULT_FORMAT = "%d개 일치 (%d원) - %d개";

    public void printLottoResult(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        for (LottoResult lottoResult : lottoResults) {
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
