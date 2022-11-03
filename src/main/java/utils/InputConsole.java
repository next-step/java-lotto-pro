package utils;

import java.util.Scanner;

public class InputConsole {

    private static final Scanner SC = new Scanner(System.in);

    public static String inputLine(String askMessage) {
        System.out.println(askMessage);
        return SC.nextLine();
    }
}
