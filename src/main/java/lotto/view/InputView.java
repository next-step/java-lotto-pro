package lotto.view;

import lotto.domain.Quantity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INVALID_NUMBER_MESSAGE = "입력값이 숫자가 아닙니다.";
    private static final String WHITE_SPACE_REGEX_STRING = "\\s";
    private static final String EMPTY = "";

    private InputView() {}

    public static int getMoney() {
        OutputView.printGetMoney();
        return parseInt(read());
    }

    public static int getManualLottoCount() {
        OutputView.printManualLottoCount();
        return parseInt(read());
    }

    public static List<String> getManualNumbers(Quantity quantity) {
        OutputView.printManualLotto();
        List<String> inputs = new ArrayList<>();

        for (int i = 0; i < quantity.value(); i++) {
            inputs.add(read().replaceAll(WHITE_SPACE_REGEX_STRING, EMPTY));
        }

        return inputs;
    }

    public static String getWiningNumber() {
        OutputView.printWinningNumber();
        return read().replaceAll(WHITE_SPACE_REGEX_STRING, EMPTY);
    }

    public static int getBonusNumber() {
        OutputView.printBonusNumber();
        return parseInt(read());
    }

    private static String read() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE, e);
        }
    }
}
