package lotto.system;

import java.util.ArrayList;
import lotto.match.Rank;
import lotto.machine.Result;

public class OutputView {

    public static void printInputMoney() {
        println("구매 금액을 입력해 주세요.");
    }

    public static void printReceipt(int quantity) {
        println(quantity + "개를 구매했습니다.");
    }

    public static void printInputWinnerNumbers() {
        println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printNotValidLottoNumbers() {
        println("유효하지 않은 로또 번호입니다.");
    }

    public static void printInputBonusNumber() {
        println("보너스 번호를 입력하세요");
    }

    public static void printLotto(ArrayList<Integer> numbers){
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < numbers.size(); i++) {
            builder.append(numbers.get(i));
            builder.append(separator(numbers.size(), i));
        }
        builder.append("]");
        OutputView.println(builder.toString());
    }

    private static String separator(int size, int i) {
        return (i != size-1) ? ", " : "";
    }

    public static void printResult(Result result) {
        println("\n당첨 통계");
        println(Rank.FOURTH.getCountOfMatch() + "개 일치("+ Rank.FOURTH.getAmount() + ")원 -" + result.getFourCount() + "개");
        println(Rank.FIFTH.getCountOfMatch() + "개 일치("+ Rank.FIFTH.getAmount() + ")원 -" + result.getThreeCount() + "개");
        println(Rank.THIRD.getCountOfMatch() + "개 일치("+ Rank.THIRD.getAmount() + ")원 -" + result.getSecondCount() + "개");
        println(Rank.SECOND.getCountOfMatch() + "개 일치, 보너스 볼 일치("+ Rank.SECOND.getAmount() + ")원 -" + result.getSecondCount() + "개");
        println(Rank.FIRST.getCountOfMatch() + "개 일치("+ Rank.FIRST.getAmount() + ")원 -" + result.getFirstCount() + "개");
        println("총 수익률은 " + result.yieldRate() + "입니다.(기준이 1이기때문에, 1 이하는 손해임)");
    }

    public static void println(String message){
        System.out.println(message);
    }

}
