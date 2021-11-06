package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersFactory {
    public static final String COMMA = ", ";
    private static final Pattern ONLY_POSITIVE_NUMBER = Pattern.compile("[0-9]+");

    private LottoNumbersFactory() {
    }

    public static List<Integer> createLottoNumbers() {
        List<Integer> allLottoNumbers = createAllLottoNumbers();
        Collections.shuffle(allLottoNumbers);
        List<Integer> lottoNumbers = allLottoNumbers.subList(
            LottoNumbersSize.LOTTO_NUMBERS_ZERO_SIZE.getSize(), LottoNumbersSize.LOTTO_NUMBERS_SIZE.getSize());
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> createAllLottoNumbers() {
        return IntStream.range(LottoNumberRange.LOTTO_NUMBER_MIN_RANGE.getRange(),
                LottoNumberRange.LOTTO_NUMBER_MAX_RANGE.getRange())
            .boxed()
            .collect(Collectors.toList());
    }

    public static List<Integer> createManualLottoNumbers(String inputNumbers) {
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
            throw new IllegalArgumentException(Message.NON_POSITIVE_LOTTO_NUMBER_MESSAGE.getMessage());
        }
    }
}
