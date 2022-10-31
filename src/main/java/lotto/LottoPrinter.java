package lotto;

import java.io.PrintStream;

public class LottoPrinter {

    private static final PrintStream ps = System.out;

    public static void print(String message) {
        ps.println(message);
    }

    public static void newLine() {
        ps.println();
    }
}
