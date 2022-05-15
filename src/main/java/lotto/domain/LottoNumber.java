package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumber {
    private final static int LOTTO_NUMBER_SIZE_VALUE = 6;
    private final static int LOTTO_NUMBER_MIN_VALUE = 1;
    private final static int LOTTO_NUMBER_MAX_VALUE = 45;
    public static final String ERROR_LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE = "[ERROR] 로또 번호는 1 ~ 45 사이의 숫자로 구성되어야합니다.";

    private final List<Integer> numbers;

    public LottoNumber() {
        this.numbers = issueLottoNumber(createRandomLottoNumber());
    }

    public LottoNumber(List<Integer> numbers) {
        this.numbers = issueLottoNumber(numbers);
    }

    private List<Integer> createRandomLottoNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = LOTTO_NUMBER_MIN_VALUE; i <= LOTTO_NUMBER_MAX_VALUE; i++) {
            randomNumbers.add(i);
        }
        return randomNumbers;
    }

    private List<Integer> issueLottoNumber(List<Integer> numbers) {
        if (isValidRangeLottoNumber(numbers)) {
           throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_OUT_OF_RANGE_MESSAGE);
        }
        shuffleNumbers(numbers);
        return sortedLottoNumber(divideNumberList(numbers));
    }

    private boolean isValidRangeLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_NUMBER_MIN_VALUE || number > LOTTO_NUMBER_MAX_VALUE);
    }

    private void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private List<Integer> divideNumberList(List<Integer> numbers) {
        return numbers.subList(0, LOTTO_NUMBER_SIZE_VALUE);
    }

    public int lottoNumberCount() {
        return LOTTO_NUMBER_SIZE_VALUE;
    }

    public List<Integer> sortedLottoNumber(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int winningCount(List<Integer> answerNumberList) {
        return (int) this.numbers.stream()
                        .filter(answerNumberList::contains)
                        .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}

