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
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개가 존재해야 합니다. (입력값: " + numbers.size());
        }
    }

    public boolean isContainNumber(Number number) {
        return numbers.contains(number);
    }

    public String getLottoTicketString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Number number : numbers) {
            stringBuilder.append(number.getNumber());
            stringBuilder.append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }
}
