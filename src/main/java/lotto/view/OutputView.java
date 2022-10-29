package lotto.view;

import lotto.Lotto;
import lotto.LottoResult;

import static lotto.LottoResult.PRIZE_MONEY;

public class OutputView {

    public static void printLottos(Lotto lotto){
        System.out.println(lotto);
    }

    public static void printLottoAmount(int lottoAmount){
        System.out.println(lottoAmount+"개를 구매했습니다.");
    }

    public static void printLottoResult(LottoResult lottoResult){
        System.out.println("당첨 통계");
        System.out.println("------------");
        for(int i=3; i< PRIZE_MONEY.length; i++){
            System.out.println(i + "개 일치(" + PRIZE_MONEY[i] + ")- "
                    + lottoResult.getLottoResult(i) + "개");
        }
        System.out.println("총 수익률은 " + lottoResult.calculateProfitRatio() + "입니다.");
    }
}
