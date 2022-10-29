package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.constant.LottoConstant;
import lotto.message.LottoMessage;
import lotto.util.LottoInputValidator;
import lotto.util.StringToIntegerConvertor;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println(LottoMessage.INPUT_PURCHASE_PRICE);
        String purchasePrice = SCANNER.nextLine();

        if (LottoInputValidator.validatePurchasePrice(purchasePrice)) {
            return Integer.parseInt(purchasePrice);
        }

        System.out.printf((LottoMessage.INVALID_PURCHASE_PRICE) + "%n", purchasePrice);
        return inputPurchasePrice();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(LottoMessage.INPUT_WINNING_NUMBERS);
        String input = SCANNER.nextLine();

        if (LottoInputValidator.validateWinningNumbers(input)) {
            return StringToIntegerConvertor.convertNumbers(input.split(LottoConstant.COMMA_DELIMITER_REGEX));
        }

        System.out.printf((LottoMessage.INVALID_WINNING_NUMBERS) + "%n", input);
        return inputWinningNumbers();
    }
}
