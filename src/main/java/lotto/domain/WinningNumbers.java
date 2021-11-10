package lotto.domain;

import java.util.*;

public class WinningNumbers {

    private final List<Number> numbers;

    public WinningNumbers(List<Number> numbers) {
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public WinningNumbers(int[] inputNumbers) {
        List<Number> numbers = convertArrayToList(inputNumbers);
        validateDuplicatedNumber(numbers);
        this.numbers = numbers;
    }

    public Map<LottoTicket, Integer> getWinningCountMap(LottoTickets lottoTickets) {
        Map<LottoTicket, Integer> winningCountCache = new HashMap<>();
        for (Number number : numbers) {
            lottoTickets.checkContainsNumber(number, winningCountCache);
        }
        return winningCountCache;
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
}
