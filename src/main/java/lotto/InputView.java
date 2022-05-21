package lotto;

import static java.util.stream.IntStream.range;
import static lotto.Message.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.Message.INPUT_MANUAL_COUNT_MESSAGE;
import static lotto.Message.INPUT_MANUAL_NUMBER_MESSAGE;
import static lotto.Message.INPUT_PURCHASE_MESSAGE;
import static lotto.Message.INPUT_WINNING_NUMBER_MESSAGE;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputPurchase() {
        System.out.printf(INPUT_PURCHASE_MESSAGE);
        return scanner.nextLine();
    }

    public String inputManualCount() {
        System.out.printf(INPUT_MANUAL_COUNT_MESSAGE);
        return scanner.nextLine();
    }

    public String[] inputManualNumbers(final int count) {
        if (count == 0) {
            return new String[]{};
        }

        System.out.printf(INPUT_MANUAL_NUMBER_MESSAGE);
        return range(0, count)
                .mapToObj(value -> scanner.nextLine())
                .toArray(String[]::new);
    }

    public String inputDrawingOfLots() {
        System.out.printf(INPUT_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
