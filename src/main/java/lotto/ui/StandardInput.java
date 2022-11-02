package lotto.ui;

import java.util.Scanner;

public class StandardInput implements Input {
    Scanner SCANNER = new Scanner(System.in);

    @Override
    public String nextLine() {
        return SCANNER.nextLine();
    }

    @Override
    public String nextLine(ConsoleMessage consoleMessage) {
        System.out.println(consoleMessage.getMessage());
        return SCANNER.nextLine();
    }
}
