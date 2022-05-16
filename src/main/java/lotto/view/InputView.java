package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String readMoney() {
        System.out.println("구입 금액을 입력해 주세요.");

        return scanner.nextLine();
    }

    public static String readWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }
}
