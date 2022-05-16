package lotto;

import static lotto.Message.INPUT_BONUS_NUMBER_MESSAGE;
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

    public String inputDrawingOfLots() {
        System.out.printf(INPUT_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public String inputBonusNumber() {
        System.out.printf(INPUT_BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
