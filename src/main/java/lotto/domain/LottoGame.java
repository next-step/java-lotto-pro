package lotto.domain;

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
        this.numbers = numbers.stream().map(n -> new LottoNumber(n)).collect(Collectors.toList());
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

    public Rank check(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        Match match = new Match((int) numbers.stream()
                .map(number -> winningNumbers.has(number))
                .filter(b -> b == true)
                .count());
        boolean matchBonus = numbers.stream().anyMatch(n -> n.equals(bonusNumber));
        return Rank.valueOf(match, matchBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
