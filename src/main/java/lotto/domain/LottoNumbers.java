package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    private static final int MAX_SIZE = 6;
    public static final String DEFAULT_DELIMITER = ",";
    private static final List<LottoNumber> DEFAULT_LOTTO_NUMBERS =
            IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1).mapToObj(LottoNumber::new).collect(Collectors.toList());

    private final List<LottoNumber> numbers;

    private LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static LottoNumbers create() {
        List<LottoNumber> numbers = new ArrayList<>(DEFAULT_LOTTO_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoNumbers(numbers.subList(0, MAX_SIZE));
    }

    public static LottoNumbers of(String text) {
        String[] numberStrings = text.split(DEFAULT_DELIMITER);
        validateStringNumbersLength(text, numberStrings);
        List<LottoNumber> numbers = new ArrayList<>();
        for (String number : numberStrings) {
            numbers.add(new LottoNumber(number));
        }
        validateDuplication(numbers);
        return new LottoNumbers(numbers);
    }

    private static void validateDuplication(List<LottoNumber> numbers) {
        Set<LottoNumber> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != MAX_SIZE) {
            throw new IllegalArgumentException(String.format("'%s'로 나누어지는 %d자리 숫자를 입력하세요", DEFAULT_DELIMITER, MAX_SIZE));
        }
    }

    private static void validateStringNumbersLength(String text, String[] numberStrings) {
        if (text.isEmpty() || numberStrings.length != MAX_SIZE) {
            throw new IllegalArgumentException(String.format("'%s'로 나누어지는 %d자리 숫자를 입력하세요", DEFAULT_DELIMITER, MAX_SIZE));
        }
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
