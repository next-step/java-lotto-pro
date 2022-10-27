package step3.io;

import java.util.Scanner;

public class Console {

    private static Scanner scanner;

    private Console() {
    }

    public static int readInt() {
        return getInstance().nextInt();
    }

    public static String readLine() {
        return getInstance().next();
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

}
