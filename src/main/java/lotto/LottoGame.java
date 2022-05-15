package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    public static final int SIZE = 6;
    public static final String ILLEGAL_SIZE_EXCEPTION_MESSAGE = "로또 번호는 " + SIZE + "개여야 합니다.";
    public static final String NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "번호는 중복되면 안 됩니다.";
    private final List<LottoNumber> numbers;

    public LottoGame(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers.stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ILLEGAL_SIZE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public Match check(List<LottoNumber> winningNumbers) {
        return new Match(
                (int) winningNumbers.stream()
                        .map(winningNumber -> this.has(winningNumber))
                        .filter(b -> b == true)
                        .count());
    }

    public boolean has(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(n -> n.equals(lottoNumber));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
