package lotto_auto.view;

import java.util.Scanner;

public class UserInputView {
    private static final Scanner scan = new Scanner(System.in);
    public static String getUserInput() {
        return scan.nextLine();
    }

    public static void closeUserInput() {
        scan.close();
    }
}
