package lotto.domain;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Number> numbers;

    public LottoTicket(List<Number> numbers) {
        validateNumbersCount(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public static LottoTicket of(List<Integer> intNumbers) {
        List<Number> numbers = convertIntegerToNumber(intNumbers);
        return new LottoTicket(numbers);
    }

    public boolean isContainNumber(Number number) {
        return numbers.contains(number);
    }

    private static List<Number> convertIntegerToNumber(List<Integer> inputNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (int number : inputNumbers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Number> duplicateCheckNumbers = new HashSet<>();
        for (Number number : numbers) {
            validateContainsNumber(duplicateCheckNumbers, number);
        }
    }

    private void validateContainsNumber(Set<Number> duplicateCheckNumbers, Number number) {
        if (duplicateCheckNumbers.contains(number)) {
            throw new IllegalArgumentException("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + number.getNumber() + ")");
        }
        duplicateCheckNumbers.add(number);
    }

    private void validateNumbersCount(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개가 존재해야 합니다. (입력값: " + numbers.size() + ")");
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }
}
