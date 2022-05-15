package step3.view;

import java.util.Scanner;
import step3.InputStatus;

public class InputView {

    private final Scanner scanIn;

    public InputView(Scanner scan) {
        this.scanIn = scan;
    }

    public String getInput(InputStatus inputStatus) {

        if (inputStatus == InputStatus.MONEY) {
            return getMoney();
        }
        if (inputStatus == InputStatus.LOTTO) {
            return getWinnerLotto();
        }
        return null;
    }

    private String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanIn.nextLine().replace(" ", "");
    }

    private String getWinnerLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanIn.nextLine().replace(" ", "");
    }
}
