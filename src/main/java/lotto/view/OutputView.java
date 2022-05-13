package lotto.view;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printLine() {
        System.out.println();
    }
}
