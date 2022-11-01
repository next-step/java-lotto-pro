package lottoauto.io;

import java.util.Scanner;

public abstract class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readConsole(){
        return scanner.nextLine();
    }
}
