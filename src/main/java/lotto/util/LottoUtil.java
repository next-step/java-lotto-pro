package lotto.util;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

public class LottoUtil {
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final String DELIMITER = ",";
    public static final int BEGIN_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private LottoUtil() {
    }

    public static Set<LottoNumber> generate() {
        List<Integer> intNumbers = IntStream.rangeClosed(BEGIN_NUMBER, END_NUMBER)
            .boxed()
            .collect(toList());
        Collections.shuffle(intNumbers);
        List<Integer> subNumbers = intNumbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(subNumbers);
        return subNumbers.stream()
            .map(LottoNumber::new)
            .collect(toSet());
    }

    public static LottoNumbers toLottoNumber(String numberString) {
        if (hasNotText(numberString)) {
            throw new IllegalStateException("당첨번호 입력을 확인해주세요. ','로 구분된 서로다른 6개 숫자여야합니다.");
        }
        Set<LottoNumber> numbers = Arrays.stream(numberString.split(DELIMITER))
            .map(s -> Integer.parseInt(s.trim()))
            .map(LottoNumber::new)
            .collect(toSet());
        return new LottoNumbers(numbers);
    }

    private static boolean hasNotText(String text) {
        if (text == null) {
            return true;
        }
        if (text.length() == 0) {
            return true;
        }
        return doesNotContainText(text);
    }

    private static boolean doesNotContainText(String text) {
        String trimmedString = text.trim();
        return isEmptyString(trimmedString);
    }

    private static boolean isEmptyString(String text) {
        return "".equals(text);
    }

}
