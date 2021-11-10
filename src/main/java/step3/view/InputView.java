package step3.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step3.common.exception.InvalidParamException;
import step3.domain.LottoNumber;
import step3.domain.LottoNumbers;
import step3.domain.LottoNumbersBundle;
import step3.domain.WinningLotto;
import step3.domain.factory.LottoNumbersFactory;

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

    public static LottoNumbersBundle readManualLottoNumbers(int tryCount) {
        ResultView.println(ViewConstant.MANUAL_LOTTO_NUMBER_MESSAGE);
        List<LottoNumbers> manualLottoNumbers = new ArrayList<>();

        for (int i = 0; i < tryCount; i++) {
            manualLottoNumbers.add(LottoNumbersFactory.createManualLottoNumbers(readLineToArray()));
        }

        return LottoNumbersBundle.of(manualLottoNumbers);
    }

    public static WinningLotto readWinningLottoNumbers() {
        ResultView.println(ViewConstant.WINNER_NUMBER_REQUEST_MESSAGE);
        try {
            LottoNumbers winningNumbers = LottoNumbersFactory.createManualLottoNumbers(readLineToArray());

            return WinningLotto.of(winningNumbers, readBonusNumber());
        } catch (InvalidParamException invalidParamException) {
            ResultView.println(invalidParamException.getMessage());

            return readWinningLottoNumbers();
        }
    }

    public static LottoNumber readBonusNumber() {
        ResultView.println(ViewConstant.BONUS_NUMBER_REQUEST_MESSAGE);

        try {

            return LottoNumber.of(scanInt());
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
            ResultView.println(ViewConstant.COMMA_INPUT_REQUEST_MESSAGE);

            return readLineToArray();
        }
    }

}
