package lotto.view;

/**
 * 사용자에게 구입 금액을 입력하도록 요청하는 메시지를 출력한다.
 */
public class DemandMoneyToBuyInputPrinter {
    private static final String DEMAND_MONEY_TO_BUY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void print() {
        System.out.println(DEMAND_MONEY_TO_BUY_INPUT_MESSAGE);
    }
}
