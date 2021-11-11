import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {


    private static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public static List<String> inputString(String message, int count) {
        System.out.println(message);
        List<String> inputStringList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputStringList.add(scanner.nextLine());
        }
        return inputStringList;
    }
}
