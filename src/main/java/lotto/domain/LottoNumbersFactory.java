package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    public static final String NON_POSITIVE_LOTTO_NUMBER_MESSAGE = "로또 번호는 문자열이나 음수가 될 수 없습니다.";
    public static final int LOTTO_NUMBERS_ZERO_SIZE = 0;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    public static final int LOTTO_NUMBER_MIN_RANGE = 1;
    public static final int LOTTO_NUMBER_MAX_RANGE = 45;
    public static final String COMMA = ",";
    private static final Pattern ONLY_POSITIVE_NUMBER = Pattern.compile("[0-9]+");

    private LottoNumbersFactory() {
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> allLottoNumbers = createAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumbers = allLottoNumbers.subList(LOTTO_NUMBERS_ZERO_SIZE, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createAllLottoNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN_RANGE, LOTTO_NUMBER_MAX_RANGE)
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> convertInputNumbersToNumbers(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] inputNumbersBySplit = inputNumbers.split(COMMA);
        for (String number : inputNumbersBySplit) {
            validatePositiveNumber(number);
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private static void validatePositiveNumber(String number) {
        if (!ONLY_POSITIVE_NUMBER.matcher(number).matches()) {
            throw new IllegalArgumentException(NON_POSITIVE_LOTTO_NUMBER_MESSAGE);
        }
    }
}
