package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputConsole {

    private static final Scanner SC = new Scanner(System.in);

    public static String inputLine(String askMessage) {
        System.out.println(askMessage);
        String input = SC.nextLine();
        System.out.println();
        return input;
    }

    public static String[] inputLines(String askMessage, long count) {
        System.out.println(askMessage);
        List<String> inputLines = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            inputLines.add(SC.nextLine());
        }
        System.out.println();
        return inputLines.toArray(new String[0]);
    }
}
