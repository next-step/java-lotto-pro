package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final String SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int inputManualLottoCountInput() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return splitNumbers(scanner.next());
    }

    public static int inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.next());
    }

    private static List<Integer> splitNumbers(final String input) {
        String[] dividedNumbers = input.trim().split(SEPARATOR);
        return Arrays.stream(dividedNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<String> inputManualLottoInput(int inputManualLottoCountInput) {
        List<String> manualLottos = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        while (inputManualLottoCountInput > 0) {
            manualLottos.add(scanner.next());
            inputManualLottoCountInput--;
        }

        return manualLottos;
    }

}
