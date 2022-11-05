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
    private static final String ASK_MESSAGE_USER_WRITTEN_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";

    public static int inputPayAmount() {
        System.out.println(ASK_MESSAGE_PAY_AMOUNT);
        return nextInt();
    }

    public static int inputBonusBall() {
        System.out.println(ASK_MESSAGE_BONUS_BALL);
        return nextInt();
    }

    public static int nextInt() {
        String input = new Scanner(System.in).next();
        InputValidator.validateNumberFormat(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> inputLottoWinningNumbers() {
        System.out.println(ASK_MESSAGE_LAST_WINNING_NUMBERS);
        return inputLottoNumbers();
    }

    public static List<Integer> inputLottoNumbers() {
        String input = new Scanner(System.in).nextLine().replaceAll(WHITE_SPACE, EMPTY_STRING);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String stringFormatNumber : input.split(WINNING_NUMBERS_DELIMITER)) {
            InputValidator.validateNumberFormat(stringFormatNumber);
            lottoNumbers.add(Integer.parseInt(stringFormatNumber));
        }
        return lottoNumbers;
    }

    public static int inputUserWrittenLottoCount() {
        System.out.println(ASK_MESSAGE_USER_WRITTEN_LOTTO_COUNT);
        return nextInt();
    }
}