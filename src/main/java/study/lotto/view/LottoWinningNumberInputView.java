package study.lotto.view;

import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.model.Lottery;
import study.lotto.model.LottoNumber;
import study.utils.Console;

import java.util.HashSet;

public class LottoWinningNumberInputView {

    private static final String LOTTO_WINNING_NUMBER_INPUT_GUIDE_MESSAGE =
            "지난 주 당첨 번호를 입력해 주세요.";

    private static final String LOTTO_WINNING_NUMBER_SIZE_ERROR_MESSAGE = "쉼표로 구분하여 총 6개의 당첨번호를 입력해야 합니다.";
    private static final String LOTTO_WINNING_NUMBER_MAL_FORMED_ERROR_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    private static final String LOTTO_WINNING_NUMBER_ONLY_NUMBER_ERROR_MESSAGE = "당첨번호는 숫자만 입력 가능합니다.";
    private static final String LOTTO_WINNING_NUMBER_NOT_EMPTY_ERROR_MESSAGE = "공백 대신 쉼표로 구분하여 총 6개의 당첨번호를 입력해주세요.";
    private static final String DELIMITER = ",";

    private LottoWinningNumberInputView() {
    }

    public static LottoWinningNumberRequestDto submit() {
        try {
            return new LottoWinningNumberRequestDto(getLottoInningNumber());
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return submit();
    }

    private static HashSet<Integer> getLottoInningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_GUIDE_MESSAGE);
        final String winningNumberStr = Console.readLine();
        validateNotNull(winningNumberStr);
        return toSet(winningNumberStr.trim());
    }

    private static void validateNotNull(final String winningNumberStr) {
        if (winningNumberStr == null || winningNumberStr.equals("")) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static HashSet<Integer> toSet(final String winningNumberStr) {
        final String[] winningNumberArr = winningNumberStr.split(DELIMITER);
        final HashSet<Integer> numberSet = new HashSet<>();
        for (final String winningNumber : winningNumberArr) {
            numberSet.add(parseLottoNumber(winningNumber));
        }
        if (numberSet.size() != Lottery.LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_SIZE_ERROR_MESSAGE);
        }
        return numberSet;
    }

    private static int parseLottoNumber(String winningNumber) {
        final int number = parseInt(winningNumber);
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_MAL_FORMED_ERROR_MESSAGE);
        }
        return number;
    }

    private static int parseInt(final String winningNumber) {
        try {
            return Integer.parseInt(winningNumber.trim());
        } catch (final NumberFormatException exception) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_ONLY_NUMBER_ERROR_MESSAGE);
        }

    }
}
