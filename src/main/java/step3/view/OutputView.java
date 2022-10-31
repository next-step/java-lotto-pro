package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoResult;
import step3.domain.LottoReturnRate;
import step3.domain.LottoWinningMoney;

import java.util.List;
import java.util.Map;

import static step3.io.InputUtils.readConsole;
import static step3.io.PrintUtils.println;

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
        Map<Integer, Integer> moneyTable = result.getWinningMoneyTable();
        println("당첨 통계");
        println("------------");
        for (Integer containCount : moneyTable.keySet()) {
            String sentence = "" + (containCount + "개 일치")
                    + (" (" + moneyTable.get(containCount) + "원)")
                    + (" - " + result.getResultCount(containCount) + "개");
            println(sentence);
        }
    }

    public static void printReturnRate(LottoReturnRate returnRate){
        println("총 수익률은 " + returnRate.toString() + "입니다.");
    }
}
