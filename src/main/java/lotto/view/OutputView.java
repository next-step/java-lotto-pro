package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import static lotto.domain.LottoResult.PRIZE_MONEY;

public class OutputView {

    private static final String OUT_MESSAGE_LOTTO_AMOUNT = "개를 구매했습니다.";
    private static final String OUT_MESSAGE_RESULT_STATISTICS = "당첨 통계";
    private static final String OUT_MESSAGE_DIVIDER_LINE = "----------";
    private static final String OUT_MESSAGE_LOTTO_RESULT = "%d개 일치(%d)- %d개\n";
    private static final String OUT_MESSAGE_PROFIT_RATIO = "총 수익률은 %.2f 입니다.";
    private static final int MIN_WINNING_NUM = 3;

    public static void printLottos(Lotto lotto){
        System.out.println(lotto);
    }

    public static void printLottoAmount(int lottoAmount){
        System.out.println(lottoAmount+OUT_MESSAGE_LOTTO_AMOUNT);
    }

    public static void printLottoResult(LottoResult lottoResult){
        System.out.println(OUT_MESSAGE_RESULT_STATISTICS);
        System.out.println(OUT_MESSAGE_DIVIDER_LINE);
        for(int i=MIN_WINNING_NUM; i< PRIZE_MONEY.length; i++){
            System.out.printf(OUT_MESSAGE_LOTTO_RESULT, i, PRIZE_MONEY[i], lottoResult.getLottoResult(i));
        }
        System.out.printf(OUT_MESSAGE_PROFIT_RATIO, lottoResult.calculateProfitRatio());
    }
}
