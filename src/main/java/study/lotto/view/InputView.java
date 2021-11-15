package study.lotto.view;

import study.StringAddCalculator;

import java.util.IllegalFormatException;
import java.util.Scanner;

import static study.lotto.view.MessageUtil.NEGATIVE_NUMBER_ERR_MSG;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String readMoney() {
        String line = sc.nextLine();
        try {
            validateNegativeNumber(line);
        } catch (IllegalStateException | IllegalFormatException e) {
            line = readMoney();
        }
        return line;
    }

    public static String readWinningLottoNumbers() {
        String line = removeSpace(sc.nextLine());
        try {
            validateInputLottoNumbers(line);
        } catch (RuntimeException e) {
            line = readWinningLottoNumbers();
        }
        return line;
    }

    private static String removeSpace(String line) {
        return line.replaceAll(" ", "");
    }

    private static void validateInputLottoNumbers(final String line) {
        validateDelimeter(line);
    }

    private static void validateDelimeter(final String line) {
        if(line.matches(".*\\d[^,]\\d.*")) {
            throw new IllegalArgumentException(StringAddCalculator.INVALID_CUSTOM_PATTERN_ERR_MSG);
        }
    }

    public static String readBonusBallNumber() {
        String line = sc.nextLine();
        try {
            validateNegativeNumber(line);
        } catch (RuntimeException e) {
            line = readBonusBallNumber();
        }
        return line;
    }

    private static void validateNegativeNumber(final String line) {
        int number = Integer.parseInt(line);
        if(number < 0) {
            throw new IllegalStateException(NEGATIVE_NUMBER_ERR_MSG);
        }
    }
}
