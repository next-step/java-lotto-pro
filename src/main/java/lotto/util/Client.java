package lotto.util;

import java.util.Scanner;

public class Client {

    private Client() {

    }

    private static final Scanner console = new Scanner(System.in);

    public static String getLineConsole() {
        return console.nextLine();
    }

}
