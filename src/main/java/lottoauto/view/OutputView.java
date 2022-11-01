package lottoauto.view;

import lottoauto.domain.Lotto;
import lottoauto.domain.LottoResult;
import lottoauto.domain.LottoReturnRate;

import java.util.List;
import java.util.Map;
import lottoauto.domain.LottoWinningMoneyEnum;

import static lottoauto.io.PrintUtils.println;

public abstract class OutputView {

    public static void buyLottoCountPrint(int count){
        println(count+"개를 구매했습니다.");
    }

    public static void printLottoNumbers(List<Lotto> lottos){
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
        for (LottoWinningMoneyEnum money : LottoWinningMoneyEnum.values()) {
            String sentence = "" + (money.getMatchedCount() + "개 일치")
                    + (" (" + money.getWinningMoney() + "원)")
                    + (" - " + result.getResultCount(money.getMatchedCount()) + "개");
            println(sentence);
        }
    }

    public static void printReturnRate(LottoReturnRate returnRate){
        println("총 수익률은 " + returnRate.toString() + "입니다.");
    }
}
