package lotto.view.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

    private Console() {
    }

    public static String readLine() {
        try {
            return BUFFERED_READER.readLine().trim();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
