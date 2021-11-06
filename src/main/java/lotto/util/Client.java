package lotto.util;

import java.util.Scanner;

public class Client {

    private static final Scanner console = new Scanner(System.in);

    private Client() {
    }

    public static String getLineConsole() {
        return console.nextLine();
    }

}
