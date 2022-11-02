package step3.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.Number;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static long inputPayment() {
        System.out.println("구입금액을 입력해주세요.");
        return Long.parseLong(scanner.nextLine());
    }

    public static int inputManualCount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Number> inputWinningNumbers() {
        printWinningNumbers();
        return inputNumbers();
    }

    public static void printWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static List<Number> inputManualNumbers() {
        return inputNumbers();
    }

    public static void printInputManualNumbers() {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<Number> inputNumbers() {
        String input = scanner.nextLine();
        return Arrays.stream(
                        input.replace(" ", "")
                                .split(","))
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static Number inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int input = Integer.parseInt(scanner.nextLine());
        return new Number(input);
    }
}
