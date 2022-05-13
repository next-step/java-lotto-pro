package lotto.model;

import static java.util.stream.Collectors.toList;
import static lotto.constants.LottoConstant.NUMBER_SIZE;
import static lotto.utils.StringUtil.isInvalidFormat;
import static lotto.utils.StringUtil.isNullOrEmpty;
import static lotto.utils.StringUtil.splitToList;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.LottoConstant;

public class LottoNumberGenerator {
    private static final List<Number> lottoNumberRange;
    private static final String LOTTO_NUMBER_FORMAT = "^([1-9]+[0-9]*,(\\s)*){5}[1-9]+[0-9]*$";
    private static final String DELIMITER = ",";

    static {
        lottoNumberRange = IntStream.range(LottoConstant.MIN_NUMBER, LottoConstant.MAX_NUMBER + 1)
                .boxed()
                .map(Number::of)
                .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static LottoNumber auto() {
        Collections.shuffle(lottoNumberRange);
        List<Number> lottoNumber = lottoNumberRange.stream()
                .limit(NUMBER_SIZE)
                .collect(toList());
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber of(List<Integer> numbers) {
        validateDuplicate(numbers);
        return new LottoNumber(wrapIntegerToNumber(numbers));
    }

    public static LottoNumber of(String numbers) {
        validateFormat(numbers);
        List<String> stringNumberList = splitToList(numbers, DELIMITER);
        List<Integer> unwrapNumberList = stringNumberList.stream()
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        validateDuplicate(unwrapNumberList);
        return new LottoNumber(wrapIntegerToNumber(unwrapNumberList));
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

    private static void validateDuplicate(List<Integer> lottoNumber) {
        Set<Integer> numberSet = new HashSet<>(lottoNumber);
        if (numberSet.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 중복은 허용되지 않습니다.");
        }
    }
}
