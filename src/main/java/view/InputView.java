package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class InputView {

    public static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_WORD = ",";

    public static int moneyInput() {
        System.out.println("구매 금액을 입력해주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputNumber() {
        String message = scanner.next();
        return splitMessage(message);
    }

    public static int bonusNumberInput() {
        System.out.println("보너스 볼을 입력해주세요.");
        return Integer.parseInt(scanner.next());
    }

    public static int manualBuyCountInput() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    private static List<Integer> splitMessage(String message) {
        return Arrays.stream(message.split(SPLIT_WORD))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void manualNumberMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void winNumberMessage() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }
}
