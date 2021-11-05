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
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public static LottoNumbers create(Shuffleable shuffler) {
        List<LottoNumber> numbers = new ArrayList<>(DEFAULT_LOTTO_NUMBERS);
        shuffler.shuffle(numbers);
        return new LottoNumbers(numbers.subList(0, MAX_SIZE));
    }

    public static LottoNumbers of(String text) {
        String[] numberStrings = text.split(DEFAULT_DELIMITER);
        validateStringNumbersLength(text, numberStrings);
        List<LottoNumber> numbers = new ArrayList<>();
        for (String number : numberStrings) {
            numbers.add(new LottoNumber(number));
        }
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

    public int getMatchedCount(LottoNumbers winningNumbers) {
        int result = 0;
        for (LottoNumber number : numbers) {
            result = getIncreasedNumberIfContains(winningNumbers, number, result);
        }
        return result;
    }

    private int getIncreasedNumberIfContains(LottoNumbers winningNumbers, LottoNumber number, int result) {
        if (winningNumbers.contains(number)) {
            return result + 1;
        }
        return result;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
