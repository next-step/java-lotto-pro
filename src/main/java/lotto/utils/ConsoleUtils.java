package lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    private ConsoleUtils() {
    }

    public static String consoleString() {
        return scanner.nextLine().replaceAll(" ", "");
    }

    public static int consoleInt() {
        return Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
    }

    public static List<Integer> consoleIntegerList() {
        String console = scanner.nextLine().replaceAll(" ", "");
        return Arrays.stream(console.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

}
