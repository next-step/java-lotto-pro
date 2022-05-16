package step3.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanIn;

    public InputView(Scanner scan) {
        this.scanIn = scan;
    }

    public String getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanIn.nextLine().replace(" ", "");
    }

    public String getWinnerLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanIn.nextLine().replace(" ", "");
    }
}
