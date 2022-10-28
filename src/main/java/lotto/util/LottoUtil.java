package lotto.util;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class LottoUtil {
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final String DELIMITER = ",";
    public static final int BEGIN_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private LottoUtil() {
    }

    public static List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(BEGIN_NUMBER, END_NUMBER)
            .boxed()
            .collect(toList());
        Collections.shuffle(numbers);
        List<Integer> lottoNumbers = numbers.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static LottoNumber toLottoNumber(String numberString) {
        if (hasNotText(numberString)) {
            throw new IllegalStateException("당첨번호 입력을 확인해주세요. ','로 구분된 서로다른 6개 숫자여야합니다.");
        }
        List<Integer> numbers = Arrays.stream(numberString.split(DELIMITER))
            .map(s -> Integer.parseInt(s.trim()))
            .collect(toList());
        return new LottoNumber(numbers);
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
