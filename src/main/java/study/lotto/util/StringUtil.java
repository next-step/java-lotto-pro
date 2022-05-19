package study.lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import study.lotto.LottoNumber;

public class StringUtil {
    private StringUtil() {
    }

    public static List<LottoNumber> splitAndParseLottoNumber(String text, String delimiter) {
        return Arrays.stream(text.split(delimiter))
                .map(String::trim)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
