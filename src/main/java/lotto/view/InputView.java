package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public void enterMoney() {
        System.out.println(INSERT_MONEY);
        String money = scanner.nextLine();
    }

}
