package study.lotto.io;

import java.util.Scanner;

public class ConsoleInput {
    private ConsoleInput() {
    }

    public static String read() {
        Scanner scanner = new Scanner(System.in);
        String result = scanner.nextLine();
        while (result.isEmpty()) {
            result = scanner.nextLine();
        }
        return result;
    }
}
