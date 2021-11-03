package lotto.util;

import java.util.Scanner;

public class Client {

    private static final Scanner console = new Scanner(System.in);

    public static String getLineConsole() {
        return console.nextLine();
    }

    public static int getIntConsole() {
        return console.nextInt();
    }
}
