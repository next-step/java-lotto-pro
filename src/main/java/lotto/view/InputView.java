package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static List<Integer> inputLotto() {
        return Arrays.stream(scanner.next().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
