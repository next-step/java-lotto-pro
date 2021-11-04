package step3.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final Scanner console = new Scanner(System.in);

    public int readLine() {
        return Integer.parseInt(console.nextLine());
    }

    public int[] readLineToArray() {
        String commaInput = console.nextLine();
        return Stream.of(commaInput.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
