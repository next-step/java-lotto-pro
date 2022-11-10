package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;

public class LottoNumberParser {
    private static final String DELIMITER = ",";

    public static List<Integer> parseLottoNumbers(String value) throws NumberFormatException, LottoNumberSizeException {
        final List<Integer> ints = Arrays.stream(value.split(DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        requireLottoNumbersSize(ints);
        requireAllNumbersValid(ints);
        return ints;
    }

    private static void requireLottoNumbersSize(List<Integer> ints) {
        if (ints.size() != LottoNumbers.SIZE) {
            throw new LottoNumberSizeException("숫자 " + LottoNumbers.SIZE + "개를 입력해야 합니다.");
        }
    }

    private static void requireAllNumbersValid(final List<Integer> ints) {
        ints.forEach(LottoNumberParser::requireValidNumber);
    }

    private static void requireValidNumber(final int number) {
        if (LottoNumber.isNotValid(number)) {
            throw new IllegalLottoNumberException("잘못된 로또 번호입니다. value=" + number);
        }
    }
}
