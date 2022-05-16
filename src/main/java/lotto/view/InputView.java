package lotto.view;

public class InputView {
    public static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";
    public static final String REQUEST_LAST_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static String readUserInput(String question) {
        System.out.println(question);
        return Console.readLine();
    }
}
