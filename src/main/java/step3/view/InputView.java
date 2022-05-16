package step3.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanIn;
    private final String GET_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private final String GET_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public InputView(Scanner scan) {
        this.scanIn = scan;
    }

    public String getMoney() {
        System.out.println(GET_MONEY_MESSAGE);
        return scanIn.nextLine().replace(" ", "");
    }

    public String getWinnerLotto() {
        System.out.println(GET_LOTTO_MESSAGE);
        return scanIn.nextLine().replace(" ", "");
    }
}
