package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputConsole {

    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    public static String readLineForMessage(String printMessage) throws IOException {
        System.out.println(printMessage);
        return BUFFERED_READER.readLine();
    }

}
