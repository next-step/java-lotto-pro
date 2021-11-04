package step3.view;

public class ResultView {
    private static final String WINNER_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BUY_COUNT_MESSAGE = "%d 개를 구매했습니다.";

    public void winnerRequestPrintln() {
        println(WINNER_NUMBER_REQUEST_MESSAGE);
    }

    public void amountRequestPrintln() {
        println(AMOUNT_REQUEST_MESSAGE);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void buyCutPrintln(int size) {
        println(String.format(BUY_COUNT_MESSAGE, size));

    }
}
