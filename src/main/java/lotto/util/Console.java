package lotto.util;

import java.util.Scanner;

public class Console {
    private static Scanner scanner = getScanner();

    public static String readLine() {
        return scanner.nextLine();
    }

    private static Scanner getScanner() {
        return new Scanner(System.in);
    }
}
