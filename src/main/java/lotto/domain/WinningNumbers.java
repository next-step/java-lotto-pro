package lotto.domain;

import java.util.*;

import static lotto.domain.LottoTicket.LOTTO_NUMBER_COUNT;

public class WinningNumbers {

    private final List<Number> numbers;

    public WinningNumbers(List<Number> numbers) {
        validateNumbersCount(numbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public WinningNumbers(int[] inputNumbers) {
        List<Number> numbers = convertArrayToList(inputNumbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public Map<LottoTicket, Integer> checkWinningCount(LottoTickets lottoTickets) {
        Map<LottoTicket, Integer> winningCountCache = new HashMap<>();
        for (Number number : numbers) {
            lottoTickets.checkContainsNumber(number, winningCountCache);
        }
        return winningCountCache;
    }

    public boolean isContains(Number number) {
        return this.numbers.contains(number);
    }

    private void validateDuplicatedNumber(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>();
        for (Number number : numbers) {
            validateContainsNumber(numberSet, number);
            numberSet.add(number);
        }
    }

    private void validateContainsNumber(Set<Number> numberSet, Number number) {
        if (numberSet.contains(number)) {
            throw new IllegalArgumentException("중복된 로또 번호가 입력될 수 없습니다. (입력값: " + number.getNumber() + ")");
        }
    }

    private List<Number> convertArrayToList(int[] inputNumbers) {
        List<Number> numbers = new ArrayList<>();
        for (int number : inputNumbers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }

    private void validateNumbersCount(List<Number> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_NUMBER_COUNT + "개가 존재해야 합니다. (입력값: " + numbers.size() + ")");
        }
    }
}
