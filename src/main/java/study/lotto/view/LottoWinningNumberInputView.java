package study.lotto.view;

import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.model.Lottery;
import study.lotto.model.LottoNumber;
import study.utils.Console;
import study.utils.StringUtils;

import java.util.HashSet;

public class LottoWinningNumberInputView {

    private static final String LOTTO_WINNING_NUMBER_INPUT_GUIDE_MESSAGE =
            "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final String LOTTO_WINNING_NUMBER_SIZE_ERROR_MESSAGE = "쉼표로 구분하여 총 6개의 당첨번호를 입력해야 합니다.";
    private static final String LOTTO_WINNING_NUMBER_MAL_FORMED_ERROR_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    private static final String LOTTO_WINNING_NUMBER_ONLY_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String LOTTO_WINNING_NUMBER_NOT_EMPTY_ERROR_MESSAGE = "공백 대신 쉼표로 구분하여 총 6개의 당첨번호를 입력해주세요.";
    private static final String LOTTO_BONUS_NUMBER_NOT_EMPTY_ERROR_MESSAGE = "보너스 번호를 숫자로 입력해 주세요.";
    private static final String DELIMITER = ",";

    private LottoWinningNumberInputView() {
    }

    public static LottoWinningNumberRequestDto submit() {
        try {
            return new LottoWinningNumberRequestDto(getLottoWinningNumber(), getBonusNumber());
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return submit();
    }

    private static int getBonusNumber() {
        System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
        final String bonusNumberStr = Console.readLine();
        validateBonusNumberNotNull(bonusNumberStr);
        return parseInt(bonusNumberStr);
    }

    private static void validateBonusNumberNotNull(final String bonusNumberStr) {
        if (StringUtils.isEmpty(bonusNumberStr)) {
            throw new InvalidLottoInputViewException(LOTTO_BONUS_NUMBER_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static HashSet<Integer> getLottoWinningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_INPUT_GUIDE_MESSAGE);
        final String winningNumberStr = Console.readLine();
        validateWinningNumberNotNull(winningNumberStr);
        return toSet(winningNumberStr.trim());
    }

    private static void validateWinningNumberNotNull(final String winningNumberStr) {
        if (StringUtils.isEmpty(winningNumberStr)) {
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

    private static int parseInt(final String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (final NumberFormatException exception) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_ONLY_NUMBER_ERROR_MESSAGE);
        }

    }
}
