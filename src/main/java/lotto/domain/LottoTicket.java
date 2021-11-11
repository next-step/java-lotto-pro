package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Number> numbers;

    public LottoTicket(List<Number> numbers) {
        validateNumbersCount(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public boolean isContainNumber(Number number) {
        return numbers.contains(number);
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>();
        for (Number number : numbers) {
            validateContainsNumber(numberSet, number);
        }
    }

    private void validateContainsNumber(Set<Number> numberSet, Number number) {
        if (numberSet.contains(number)) {
            throw new IllegalArgumentException("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + number.getNumber() + ")");
        }
        numberSet.add(number);
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
