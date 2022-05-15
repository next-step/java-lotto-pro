package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.NUMBER_SIZE;
import static lotto.utils.StringUtil.isInvalidFormat;
import static lotto.utils.StringUtil.isNullOrEmpty;
import static lotto.utils.StringUtil.splitToList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.LottoConstant;

public class LottoNumberGenerator {
    private static final List<Number> LOTTO_NUMBER_RANGE;
    private static final String LOTTO_NUMBER_FORMAT = "^([1-9]+[0-9]*,(\\s)*){5}[1-9]+[0-9]*$";
    private static final String DELIMITER = ",";

    static {
        LOTTO_NUMBER_RANGE = IntStream.rangeClosed(LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER)
                .boxed()
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<Number> auto() {
        Collections.shuffle(LOTTO_NUMBER_RANGE);
        return LOTTO_NUMBER_RANGE.stream()
                .limit(NUMBER_SIZE)
                .collect(toList());
    }

    public static List<Number> of(List<Integer> numbers) {
        return wrapIntegerToNumber(numbers);
    }

    public static List<Number> of(String numbers) {
        validateFormat(numbers);
        List<String> stringNumberList = splitToList(numbers, DELIMITER);
        List<Integer> unwrapNumberList = stringNumberList.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        return wrapIntegerToNumber(unwrapNumberList);
    }

    private static List<Number> wrapIntegerToNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::of)
                .collect(toList());
    }

    private static void validateFormat(String lottoNumber) {
        if (isNotValid(lottoNumber)) {
            throw new IllegalArgumentException("올바른 로또 번호 양식이 아닙니다.");
        }
    }

    private static boolean isNotValid(String lottoNumber) {
        return isNullOrEmpty(lottoNumber) || isInvalidFormat(lottoNumber, LOTTO_NUMBER_FORMAT);
    }
}
