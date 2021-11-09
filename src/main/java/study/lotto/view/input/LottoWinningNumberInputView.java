package study.lotto.view.input;

import study.lotto.controller.dto.LottoWinningNumberRequestDto;
import study.lotto.model.Lottery;
import study.lotto.model.LottoNumber;
import study.lotto.view.InvalidLottoInputViewException;
import study.utils.Console;
import study.utils.StringUtils;

import java.util.HashSet;
import java.util.Set;

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
    private static final String LOTTO_BONUS_NUMBER_NOT_DUPLICATED_ERROR_MESSAGE = "보너스 번호는 당첨번호와 중복될 수 없습니다.";

    private LottoWinningNumberInputView() {
    }

    public static LottoWinningNumberRequestDto submit() {
        final Set<Integer> lottoWinningNumber = getLottoWinningNumber();
        return new LottoWinningNumberRequestDto(lottoWinningNumber, getBonusNumber(lottoWinningNumber));
    }

    private static int getBonusNumber(final Set<Integer> lottoWinningNumber) {
        try {
            System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
            final String bonusNumberStr = Console.readLine();
            validateBonusNumberNotNull(bonusNumberStr);
            validateBonusNumberDuplicated(lottoWinningNumber, bonusNumberStr);
            return parseInt(bonusNumberStr);
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return getBonusNumber(lottoWinningNumber);
    }

    private static void validateBonusNumberDuplicated(final Set<Integer> lottoWinningNumber, final String bonusNumberStr) {
        if (lottoWinningNumber.contains(parseInt(bonusNumberStr))) {
            throw new InvalidLottoInputViewException(LOTTO_BONUS_NUMBER_NOT_DUPLICATED_ERROR_MESSAGE);
        }
    }

    private static void validateBonusNumberNotNull(final String bonusNumberStr) {
        if (StringUtils.isEmpty(bonusNumberStr)) {
            throw new InvalidLottoInputViewException(LOTTO_BONUS_NUMBER_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static Set<Integer> getLottoWinningNumber() {
        try {
            System.out.println(LOTTO_WINNING_NUMBER_INPUT_GUIDE_MESSAGE);
            final String winningNumberStr = Console.readLine();
            validateWinningNumberNotNull(winningNumberStr);
            return toSet(winningNumberStr.trim());
        } catch (InvalidLottoInputViewException exception) {
            System.out.println(exception.getMessage());
        }
        return getLottoWinningNumber();
    }

    private static void validateWinningNumberNotNull(final String winningNumberStr) {
        if (StringUtils.isEmpty(winningNumberStr)) {
            throw new InvalidLottoInputViewException(LOTTO_WINNING_NUMBER_NOT_EMPTY_ERROR_MESSAGE);
        }
    }

    private static Set<Integer> toSet(final String winningNumberStr) {
        final String[] winningNumberArr = winningNumberStr.split(DELIMITER);
        final Set<Integer> numberSet = new HashSet<>();
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
