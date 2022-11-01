package lotto.view;

import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String ASK_MESSAGE_PAY_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_MESSAGE_LAST_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String WINNING_NUMBERS_DELIMITER = ",";
    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static int inputPayAmount() {
        System.out.println(ASK_MESSAGE_PAY_AMOUNT);
        return nextInt();
    }

    public static int inputBonusBall() {
        System.out.println(ASK_MESSAGE_BONUS_BALL);
        return nextInt();
    }

    private static int nextInt(){
        String input = new Scanner(System.in).next();
        InputValidator.validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputLottoWinningNumbers() {
        System.out.println(ASK_MESSAGE_LAST_WINNING_NUMBERS);
        String input = new Scanner(System.in).nextLine().replaceAll(WHITE_SPACE, EMPTY_STRING);

        List<Integer> winningNumbers = new ArrayList<>();
        for (String stringFormatNumber : input.split(WINNING_NUMBERS_DELIMITER)) {
            InputValidator.validateNumberFormat(stringFormatNumber);
            winningNumbers.add(Integer.parseInt(stringFormatNumber));
        }
        return winningNumbers;
    }
}