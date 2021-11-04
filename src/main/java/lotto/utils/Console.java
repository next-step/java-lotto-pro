package lotto.utils;

import java.util.Scanner;

public class Console {

    private static final Scanner scanner = new Scanner(System.in);

    private Console() {
        throw new UnsupportedOperationException();
    }

    public static String readLine() {
        return scanner.nextLine();
    }

    public static int readInt() {
        return scanner.nextInt();
    }
}
