package lotto.view;

import lotto.model.PassiveQuantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    private static final String INPUT_PASSIVE_QUANTITY = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_PASSIVE_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS = "보너스 볼을 입력해 주세요.";

    public static String inputPrice() {
        System.out.println(INPUT_PRICE);
        return scanner.next();
    }

    public static String inputPassiveQuantity() {
        System.out.println(INPUT_PASSIVE_QUANTITY);
        return scanner.next();
    }

    public static List<String> inputPassiveNumbers(PassiveQuantity passiveQuantity) {
        System.out.println(INPUT_PASSIVE_NUMBERS);
        List<String> passiveNumbers = new ArrayList<>();
        for (int i = 0; i < passiveQuantity.getQuantity(); i++) {
            scanner.useDelimiter("\n");
            passiveNumbers.add(scanner.next());
        }
        return passiveNumbers;
    }

    public static String inputLottoNumbers() {
        System.out.println(INPUT_NUMBERS);
        return scanner.next();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS);
        return scanner.next();
    }
}
