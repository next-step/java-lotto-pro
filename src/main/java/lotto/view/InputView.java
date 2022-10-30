package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static String startLottoInput() {
        return scanner.nextLine();
    }

    public static String getWinningLottoNumInput() {
        return scanner.nextLine();
    }
}
