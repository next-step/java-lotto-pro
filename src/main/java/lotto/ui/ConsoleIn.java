package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleIn {

    private ConsoleIn() {
    }

    public static PurchaseAmount inputPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        while (Objects.isNull(purchaseAmount)) {
            purchaseAmount = getPurchaseAmount();
        }
        return purchaseAmount;
    }

    public static Lotto inputWinNumber() {
        Lotto winNumber = null;
        while (Objects.isNull(winNumber)) {
            winNumber = getWinNumber();
        }
        return winNumber;
    }

    private static PurchaseAmount getPurchaseAmount() {
        try {
            String input = input(Message.PURCHASE_AMOUNT_INPUT.getMessage());
            checkDigit(input);
            return new PurchaseAmount(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static Lotto getWinNumber() {
        try {
            String input = input(Message.WIN_NUMBER_INPUT.getMessage());
            List<String> tokens = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            checkWinNumber(tokens);

            return new Lotto(tokens.stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static String input(String message) {
        ConsoleOut.printMessage(message);
        return new Scanner(System.in).nextLine();
    }

    private static void checkWinNumber(List<String> tokens) {
        for (String token : tokens) {
            checkDigit(token);
        }
    }

    private static void checkDigit(String input) {
        if (!isDigit(input)) {
            throw new IllegalArgumentException(Message.NOT_DIGIT_ERROR.getMessage());
        }
    }

    private static boolean isDigit(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
