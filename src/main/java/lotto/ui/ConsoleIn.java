package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoType;
import lotto.domain.PurchaseAmount;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleIn {

    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleIn() {
    }

    public static PurchaseAmount inputPurchaseAmount() {
        PurchaseAmount purchaseAmount = null;
        while (Objects.isNull(purchaseAmount)) {
            purchaseAmount = getPurchaseAmount();
        }
        return purchaseAmount;
    }

    public static Lotto inputLotto(Message message) {
        Lotto lotto = null;
        while (Objects.isNull(lotto)) {
            lotto = getLotto(message);
        }
        return lotto;
    }

    public static LottoNumber inputBonusNumber() {
        LottoNumber bonusNumber = null;
        while (Objects.isNull(bonusNumber)) {
            bonusNumber = getBonusNumber();
        }
        return bonusNumber;
    }

    public static Integer inputManualQuantity() {
        Integer manualQuantity = null;
        while (Objects.isNull(manualQuantity)) {
            manualQuantity = getManualQuantity();
        }
        return manualQuantity;
    }

    private static PurchaseAmount getPurchaseAmount() {
        try {
            String input = input(Message.PURCHASE_AMOUNT_INPUT);
            checkDigit(input);
            return new PurchaseAmount(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static Lotto getLotto(Message message) {
        try {
            String input = (message == Message.EMPTY ? input() : input(message));
            List<String> tokens = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            checkWinNumber(tokens);

            return Lotto.from(tokens.stream()
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static LottoNumber getBonusNumber() {
        try {
            String input = input(Message.BONUS_NUMBER_INPUT);
            checkDigit(input);
            return new LottoNumber(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static Integer getManualQuantity() {
        try {
            String input = input(Message.MANUAL_QUANTITY_INPUT);
            checkDigit(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            ConsoleOut.printErrorMessage(e);
        }
        return null;
    }

    private static String input(Message message) {
        ConsoleOut.printMessage(message.getMessage());
        return SCANNER.nextLine();
    }

    private static String input() {
        return SCANNER.nextLine();
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
