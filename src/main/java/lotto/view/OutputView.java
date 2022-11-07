package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoReturnRate;

import java.util.List;
import lotto.domain.LottoWinningRank;

import static lotto.io.PrintUtils.println;

public abstract class OutputView {

    public static final int ZERO = 0;

    public static void buyLottoCountPrint(int count){
        println(count+"개를 구매했습니다.");
    }

    public static void printManualLottoInput(int manualLottoCount){
        if(manualLottoCount > ZERO){
            println("수동으로 구매할 번호를 입력해 주세요.");
        }
    }
    public static void printBuyLottoCount(int autoLottoCount, int manualLottoCount){
        println("수동으로 "+ manualLottoCount + "장, 자동으로 "+ autoLottoCount + "장을 구매했습니다." );
    }

    public static void  printLottoNumbers(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            println(lotto.toString());
        }
    }

    public static void printLastWeekWinningNumber(){
        println("지난 주 당첨 번호를 입력해 주세요.");
    }


    public static void printWinningStats(LottoResult result){
        println("당첨 통계");
        println("------------");
        for (LottoWinningRank money : LottoWinningRank.values()) {
            if(money!= LottoWinningRank.MISS) {
                String sentence = "" + (money.getMatchedCount() + "개 일치"
                        + (money== LottoWinningRank.SECOND ? ", 보너스 볼 일치" : ""))
                        + (" (" + money.getWinningMoney() + "원)")
                        + (" - " + result.getResultCount(money) + "개");
                println(sentence);
            }
        }
    }

    public static void printReturnRate(LottoReturnRate returnRate){
        println("총 수익률은 " + returnRate.toString() + "입니다.");
    }
}
