package study.lottoAuto;

import study.StringAddCalculator;

import java.util.IllegalFormatException;
import java.util.Scanner;

import static study.lottoAuto.MessageUtil.*;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public static String readMoney() {
        String line = sc.nextLine();
        try {
            validateMoney(line);
        } catch (IllegalStateException | IllegalFormatException e) {
            line = readMoney();
        }
        return line;
    }

    private static void validateMoney(final String line) {
        int money = Integer.parseInt(line);
        if(money < 0) {
            throw new IllegalStateException(NEGATIVE_NUMBER_ERR_MSG);
        }
    }

    public static String readLastLottoNumbers() {
        String line = removeSpace(sc.nextLine());
        try {
            validateInputLottoNumbers(line);
        } catch (RuntimeException e) {
            line = readLastLottoNumbers();
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
}
