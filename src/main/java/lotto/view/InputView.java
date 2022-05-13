package lotto.view;

public class InputView {
    public static final String REQUEST_MONEY = "구입금액을 입력해 주세요.";

    public static String readUserInput(String question) {
        System.out.println(question);
        return Console.readLine();
    }
}
