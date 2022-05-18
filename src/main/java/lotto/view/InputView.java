package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int inputBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return newScanner().nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return newScanner().nextLine();
    }

    private static Scanner newScanner() {
        return new Scanner(System.in);
    }
}
