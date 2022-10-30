package lotto.ui;

import lotto.domain.Quantity;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.ui.ConsoleMessage.*;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SEPARATOR = ",";

    private InputView() {
    }

    private static String input() {
        return SCANNER.nextLine();
    }

    private static String input(ConsoleMessage message) {
        ResultView.printMessage(message.getMessage());
        return SCANNER.nextLine();
    }

    public static List<Integer> inputWinningNumber() {
        String input = InputView.input(INPUT_WINNING_NUMBER);
        return mapToWinningNumber(input);
    }

    public static List<Integer> inputManualLottoNumber() {
        return mapToWinningNumber(InputView.input());
    }

    private static List<Integer> mapToWinningNumber(final String input) {
        String[] splitNumbers = split(input);
        return Arrays.stream(splitNumbers)
                .map(value -> validNumberFormat(Integer::parseInt, value.trim()))
                .collect(Collectors.toList());
    }

    private static String[] split(final String input) {
        return input.split(SEPARATOR);
    }

    public static int inputPurchaseAmount() {
        String inputAmount = InputView.input(INPUT_PURCHASE_AMOUNT);
        return validNumberFormat(Integer::parseInt, inputAmount);
    }

    public static int validNumberFormat(Function<String, Integer> parseInt, final String number) {
        try {
            return parseInt.apply(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_VALID_NUMBER_FORMAT.getMessage(), number));
        }
    }

    public static int inputBonusNumber() {
        return validNumberFormat(Integer::parseInt, InputView.input(INPUT_BONUS_NUMBER));
    }

    public static Quantity inputQuantity(final int purchaseAmount) {
        int manualQuantity = inputManualQuantity(purchaseAmount);
        int autoQuantity = getAvailableAutoQuantity(purchaseAmount, manualQuantity);
        return new Quantity(manualQuantity, autoQuantity);
    }

    private static int getAvailableAutoQuantity(final int purchaseAmount, final int quantity) {
        return (purchaseAmount - (LOTTO_PRICE * quantity)) / LOTTO_PRICE;
    }

    private static int inputManualQuantity(final int purchaseAmount) {
        int quantity = validNumberFormat(
                Integer::parseInt, InputView.input(INPUT_PURCHASE_MANUAL_LOTTO_COUNT)
        );

        if (purchaseAmount < LOTTO_PRICE * quantity) {
            throw new IllegalArgumentException(
                    String.format(ERROR_VALID_LOTTO_PRICE.getMessage(), purchaseAmount, quantity)
            );
        }

        return quantity;
    }
}
