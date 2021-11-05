package lotto.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public InputView() {
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
