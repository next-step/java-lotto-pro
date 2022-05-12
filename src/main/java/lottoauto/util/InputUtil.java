package lottoauto.util;

import lottoauto.wrapper.Lotto;
import lottoauto.wrapper.Price;

import java.util.Scanner;
import java.util.regex.Matcher;

public class InputUtil {
    String input;
    private static final String BASIC_REGEX = ", ";

    public InputUtil() {
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
    }

    public String getInput() {
        return input;
    }

    public String[] checkRegex() {
        return input.split(BASIC_REGEX);
    }
}
