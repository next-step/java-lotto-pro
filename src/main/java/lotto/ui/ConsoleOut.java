package lotto.ui;

public class ConsoleOut {

    public static final String ERROR_PREFIX = "[ERROR]";

    private ConsoleOut() {
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage(String message, Object... args) {
        System.out.printf(message, args);
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        System.out.printf("%s %s%n", ERROR_PREFIX, e.getMessage());
    }

    public static void newLine() {
        System.out.println();
    }
}
