package lotto.view;

import static lotto.common.ViewMessage.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.common.ViewMessage.INPUT_MANUAL_LOTTO_COUNT_MESSAGE;
import static lotto.common.ViewMessage.INPUT_MANUAL_LOTTO_NUMBER_MESSAGE;
import static lotto.common.ViewMessage.INPUT_MONEY_MESSAGE;
import static lotto.common.ViewMessage.INPUT_WIN_LOTTO_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static String inputWinLotto() {
        System.out.println(INPUT_WIN_LOTTO_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return scanner.nextInt();
    }

    public static String inputManualLottoCount() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static void printInputManualLottoNumberHeader() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_MESSAGE.getMessage());
    }

    public static List<String> inputManualLottoNumbers(int count) {
        List<String> inputNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputNumbers.add(scanner.nextLine());
        }
        return inputNumbers;
    }

    public static void printLine() {
        System.out.println();
    }
}
