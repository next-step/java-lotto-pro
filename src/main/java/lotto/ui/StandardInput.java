package lotto.ui;

import java.util.Scanner;

public class StandardInput implements Input {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public String[] inputNumbers() {
        return scanner.nextLine().split(",");
    }
}
