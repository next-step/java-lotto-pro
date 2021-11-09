package study.lottoAuto;

import study.StringAddCalculator;

import java.util.IllegalFormatException;
import java.util.Scanner;

import static study.lottoAuto.MessageUtil.*;

public class InputView {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

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
        if(money < 1000) {
            throw new IllegalStateException(MINIMUM_MONEY_INPUT_ERR_MSG);
        }
    }

    public static String readLastLottoNumbers() {
        String line = removeSpace(sc.nextLine());
        try {
            validateLastLottoNumbers(line);
        } catch (RuntimeException e) {
            line = readLastLottoNumbers();
        }
        return line;
    }

    private static String removeSpace(String line) {
        return line.replaceAll(" ", "");
    }

    private static void validateLastLottoNumbers(final String line) {

        validateDelimeter(line);

        String[] lottoNumbers = line.split(",");
        for(String lottoNumber : lottoNumbers) {
            validateLottoNumber(lottoNumber);
        }
    }

    private static void validateDelimeter(final String line) {
        if(line.matches(".*\\d[^,]\\d.*")) {
            throw new IllegalArgumentException(StringAddCalculator.INVALID_CUSTOM_PATTERN_ERR_MSG);
        }
    }

    private static void validateLottoNumber(String lottoNumber) {
        if(Integer.parseInt(lottoNumber) < MIN_LOTTO_NUMBER || Integer.parseInt(lottoNumber) > MAX_LOTTO_NUMBER) {
            throw new IllegalStateException(INVALID_LOTTO_NUMBER_ERR_MSG);
        }
    }

}
