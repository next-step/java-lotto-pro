package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.constant.LottoConstant;
import lotto.message.ErrorMessages;
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

        System.out.printf((ErrorMessages.INVALID_PURCHASE_PRICE) + "%n", purchasePrice);
        return inputPurchasePrice();
    }

    public static int inputManualLottoCount(int total) {
        System.out.println(LottoMessage.INPUT_MANUAL_LOTTO_COUNT);
        String input = SCANNER.nextLine();

        if (LottoInputValidator.validateManualLottoCount(total, input)) {
            return StringToIntegerConvertor.convertNumber(input);
        }

        System.out.printf((ErrorMessages.INVALID_MANUAL_PURCHASABLE_QUANTITY) + "%n", total);
        return inputManualLottoCount(total);
    }

    public static List<List<Integer>> inputManualLottos(int manual) {
        System.out.println(LottoMessage.INPUT_MANUAL_LOTTO_NUMBERS);
        List<List<Integer>> manualLottos = new ArrayList<>();

        for (int i = 0; i < manual; i++) {
            manualLottos.add(inputLottoNumbers());
        }

        return manualLottos;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(LottoMessage.INPUT_WINNING_NUMBERS);
        return inputLottoNumbers();
    }

    private static List<Integer> inputLottoNumbers() {
        String input = SCANNER.nextLine();

        if (LottoInputValidator.validateLottoNumbers(input)) {
            return StringToIntegerConvertor.convertNumbers(input.split(LottoConstant.COMMA_DELIMITER_REGEX));
        }

        System.out.printf((ErrorMessages.INVALID_LOTTO_NUMBERS) + "%n", input);
        return inputLottoNumbers();
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println(LottoMessage.INPUT_BONUS_NUMBER);
        String input = SCANNER.nextLine();

        if (LottoInputValidator.validateBonusNumber(input, winningNumbers)) {
            return StringToIntegerConvertor.convertNumber(input);
        }

        System.out.printf((ErrorMessages.INVALID_BONUS_NUMBER) + "%n", input);
        return inputBonusNumber(winningNumbers);
    }
}
