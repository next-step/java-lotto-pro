package study.step3.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static String input() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            // do nothing
        }
        return input;
    }
}
