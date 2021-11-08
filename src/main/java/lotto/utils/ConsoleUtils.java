package lotto.utils;

import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleUtils() {
    }

    public static String console() {
        return scanner.nextLine().replaceAll(" ", "");
    }

}
