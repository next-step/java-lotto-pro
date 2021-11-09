package step3.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step3.common.exception.InvalidParamException;
import step3.domain.strategy.numbers.ManualLottoNumbers;
import step3.domain.strategy.numbers.NumbersStrategy;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int readLottoAmount() {
        try {
            ResultView.println(ViewConstant.AMOUNT_REQUEST_MESSAGE);
            return scanInt();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return readLottoAmount();
        }
    }

    public static int readLottoManualBuyCount() {
        try {
            ResultView.println(ViewConstant.MANUAL_LOTTO_COUNT_MESSAGE);
            return scanInt();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return readLottoManualBuyCount();
        }
    }

    public static List<NumbersStrategy> readManualLottoNumbers(int tryCount) {
        ResultView.println(ViewConstant.MANUAL_LOTTO_NUMBER_MESSAGE);
        List<NumbersStrategy> manualLottoNumbers = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            manualLottoNumbers.add(new ManualLottoNumbers(readLineToArray()));
        }

        return manualLottoNumbers;
    }

    public static NumbersStrategy readWinningLottoNumbers() {
        ResultView.println(ViewConstant.WINNER_NUMBER_REQUEST_MESSAGE);
        try {
            return new ManualLottoNumbers(readLineToArray());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return readWinningLottoNumbers();
        }
    }

    public static int readBonusNumber() {
        ResultView.println(ViewConstant.BONUS_NUMBER_REQUEST_MESSAGE);

        try {

            return scanInt();
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return readBonusNumber();
        }
    }

    private static int scanInt() {
        String result = sc.nextLine();

        if (!result.chars().allMatch(Character::isDigit)) {
            throw new InvalidParamException(ViewConstant.ONLY_NUMBER);
        }

        return Integer.parseInt(result);
    }

    private static List<Integer> readLineToArray() {
        try {
            return Arrays.stream(sc.nextLine().split(","))
                .filter(number -> number.chars().allMatch(Character::isDigit))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        } catch (InvalidParamException invalidParamException) {
            step3.view.ResultView.println(ViewConstant.COMMA_INPUT_REQUEST_MESSAGE);

            return readLineToArray();
        }
    }

}
