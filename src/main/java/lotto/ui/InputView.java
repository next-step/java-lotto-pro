package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LottoPrice;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private InputView() {
    }

    private static String input(ConsoleMessage message) {
        ResultView.printMessage(message.getMessage());
        return SCANNER.nextLine();
    }

    public static List<Integer> inputWinningNumber() {
        String input = InputView.input(ConsoleMessage.INPUT_WINNING_NUMBER);
        return mapToWinningNumber(input);
    }

    private static List<Integer> mapToWinningNumber(final String input) {
        String[] splitNumbers = split(input);
        return Arrays.stream(splitNumbers)
                .map(o -> Integer.parseInt(o.trim()))
                .collect(Collectors.toList());
    }

    private static String[] split(final String input) {
        return input.split(SEPARATOR);
    }

    public static int inputPurchaseAmount() {
        String purchaseAmount = InputView.input(ConsoleMessage.INPUT_PURCHASE_AMOUNT);
        return getQuantity(purchaseAmount);
    }

    private static int getQuantity(final String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) / LottoPrice;
    }
}
