package lotto.view;

import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ASK_MESSAGE_PAY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_MESSAGE_LAST_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static int inputPayAmount() {
        System.out.println(ASK_MESSAGE_PAY_AMOUNT);
        String input = new Scanner(System.in).next();
        InputValidator.validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputLottoWinningNumbers() {
        System.out.println(ASK_MESSAGE_LAST_WINNING_NUMBERS);
        String input = new Scanner(System.in).nextLine().replaceAll(WHITE_SPACE, EMPTY_STRING);
        String[] stringWinningNumbers = input.split(WINNING_NUMBERS_DELIMITER);
        InputValidator.validateLottoNumberCount(stringWinningNumbers.length);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String stringFormatNumber : stringWinningNumbers) {
            InputValidator.validateNumberFormat(stringFormatNumber);
            int number = Integer.parseInt(stringFormatNumber);
            InputValidator.validateLottoNumberRange(number);
            winningNumbers.add(number);
        }
        InputValidator.validateDuplicateLottoNumber(winningNumbers);

        return winningNumbers;
    }
}
