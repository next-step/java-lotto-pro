package step3.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import step3.domain.LottoCount;

public class InputView {

    private static final String NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputNumber();
    }

    public static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return inputNumber();
    }

    public static List<List<Integer>> inputManualLottoNumbers(LottoCount manualLottoCount) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        for(int i = 0; i < manualLottoCount.get(); i++) {
            manualLottoNumbers.add(inputNumbers());
        }
        return manualLottoNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputNumber();
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputNumbers();
    }

    private static List<Integer> inputNumbers() {
        try {
            return Arrays.stream(inputText().split(NUMBER_DELIMITER))
                    .map(text -> Integer.parseInt(text.trim()))
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

    private static int inputNumber() {
        try {
            return Integer.parseInt(inputText());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static String inputText() {
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}
