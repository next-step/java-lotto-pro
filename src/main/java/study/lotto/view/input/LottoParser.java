package study.lotto.view.input;

import study.lotto.model.Lottery;
import study.lotto.view.InvalidLottoInputViewException;

import java.util.HashSet;
import java.util.Set;

public class LottoParser {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final String LOTTO_NUMBER_SIZE_ERROR_MESSAGE = "쉼표로 구분하여 총 6개의 당첨번호를 입력해야 합니다.";
    private static final String LOTTO_NUMBER_MAL_FORMED_ERROR_MESSAGE = "로또번호는 1부터 45까지의 숫자로 구성되어야 합니다.";
    private static final String ONLY_NUMBER_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    private LottoParser() {
    }

    public static Set<Integer> parseSet(final String text, final String delimiter) {
        final String[] numbers = text.split(delimiter);
        final Set<Integer> numberSet = new HashSet<>();
        for (final String winningNumber : numbers) {
            numberSet.add(parseLottoNumber(winningNumber));
        }
        if (numberSet.size() != Lottery.LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoInputViewException(LOTTO_NUMBER_SIZE_ERROR_MESSAGE);
        }
        return numberSet;
    }

    private static int parseLottoNumber(String text) {
        final int number = parseNumber(text);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoInputViewException(LOTTO_NUMBER_MAL_FORMED_ERROR_MESSAGE);
        }
        return number;
    }

    public static int parseNumber(final String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (final NumberFormatException exception) {
            throw new InvalidLottoInputViewException(ONLY_NUMBER_ERROR_MESSAGE);
        }
    }
}
