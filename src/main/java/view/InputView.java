package view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String SPLITTER = ",";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = toList(scanner.nextLine());
        System.out.print("\n");
        return winningNumbers;
    }

    public static int inputBonusWinningNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputCountOfSelfPickLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Set<Integer>> inputSelfPickNumbers(int countOfSelfPickLotto) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> selfPickNumbers = new ArrayList<>();
        for (int i = 0; i < countOfSelfPickLotto; i++) {
            selfPickNumbers.add(new HashSet<>(toList(scanner.nextLine())));
        }
        return selfPickNumbers;
    }

    private static List<Integer> toList(String s) {
        return Arrays.stream(s.split(SPLITTER))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
