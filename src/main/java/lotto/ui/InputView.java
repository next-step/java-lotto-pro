package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_PRICE;
import static lotto.ui.ConsoleMessage.*;

public class InputView {

    private static final String SEPARATOR = ",";
    private final Input input;

    public InputView(Input input) {
        this.input = input;
    }

    public List<Integer> inputWinningNumber() {
        return mapToWinningNumber(input.nextLine(INPUT_WINNING_NUMBER));
    }

    public List<Integer> inputManualLottoNumber() {
        return mapToWinningNumber(input.nextLine());
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

    public int inputPurchaseAmount() {
        String inputAmount = input.nextLine(INPUT_PURCHASE_AMOUNT);
        return validNumberFormat(Integer::parseInt, inputAmount);
    }

    public static int validNumberFormat(Function<String, Integer> parseInt, final String number) {
        try {
            return parseInt.apply(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(ERROR_VALID_NUMBER_FORMAT.getMessage(), number));
        }
    }

    public int inputBonusNumber() {
        return validNumberFormat(Integer::parseInt, input.nextLine(INPUT_BONUS_NUMBER));
    }

    public static int getAvailableAutoQuantity(final int purchaseAmount, final int quantity) {
        return (purchaseAmount - (LOTTO_PRICE * quantity)) / LOTTO_PRICE;
    }

    public int inputManualQuantity(final int purchaseAmount) {
        int quantity = validNumberFormat(
                Integer::parseInt, input.nextLine(INPUT_PURCHASE_MANUAL_LOTTO_COUNT)
        );

        if (purchaseAmount < LOTTO_PRICE * quantity) {
            throw new IllegalArgumentException(
                    String.format(ERROR_VALID_LOTTO_PRICE.getMessage(), purchaseAmount, quantity)
            );
        }

        return quantity;
    }
}
