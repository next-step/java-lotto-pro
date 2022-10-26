package lotto.system;

import lotto.Match.Match;
import lotto.machine.Result;

public class OutputView {

    public static void printInputMoney() {
        System.out.println("구매 금액을 입력해 주세요.");
    }

    public static void printReceipt(int quantity) {
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public static void printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printNotValidLottoNumbers() {
        System.out.println("유효하지 않은 로또 번호입니다.");
    }

    public static void printResult(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        System.out.println(Match.THREE.getCount() + "개 일치("+Match.THREE.getAmount() + ")원-" + result.getThreeCount() + "개");
        System.out.println(Match.FOUR.getCount() + "개 일치("+Match.FOUR.getAmount() + ")원-" + result.getFourCount() + "개");
        System.out.println(Match.FIVE.getCount() + "개 일치("+Match.FIVE.getAmount() + ")원-" + result.getFiveCount() + "개");
        System.out.println(Match.SIX.getCount() + "개 일치("+Match.SIX.getAmount()+ " )원-" + result.getSixCount() + "개");

        float rate = result.calculatorYieldRate();
        System.out.println("총 수익률은 " + rate + "입니다.(기준이 1이기 떄문에 결과적으로는 손해라는 의미임)");

    }
}
