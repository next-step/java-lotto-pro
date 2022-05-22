package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchasedMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Set<Integer> inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputLottoNumberToSet(scanner.nextLine());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputPurchaseManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void inputPurchaseManualLotto() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static Set<Integer> inputEmptyAsk() {
        return inputLottoNumberToSet(scanner.nextLine());
    }

    private static Set<Integer> inputLottoNumberToSet(String inputLottoNumbers) {;
        String[] stringArr = inputLottoNumbers.replace(" ", "").split(",");
        return Arrays.stream(stringArr)
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
    }

}
