package lotto.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.constant.ErrorMessage;

public class InputConsoleUtils {

    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    public static final String TAP = "\t";

    private InputConsoleUtils() {
        throw new IllegalStateException(ErrorMessage.UTILITY_CLASS);
    }

    public static String readLineForMessage(String printMessage) throws IOException {
        System.out.println(TAP);
        System.out.println(printMessage);
        return BUFFERED_READER.readLine();
    }

    public static String readLine() throws IOException {
        return BUFFERED_READER.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(TAP);
        System.out.println(message);
    }

    public static void printMessage(String message, boolean isSkip) {
        if (!isSkip) {
            printMessage(message);
        }
    }

}
