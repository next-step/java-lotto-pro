package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.domain.ExceptionMessage.ILLEGAL_SIZE;
import static lotto.domain.ExceptionMessage.NUMBER_DUPLICATE;

public class LottoGame {

    public static final int SIZE = 6;
    private final List<LottoNumber> numbers;

    public LottoGame(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public LottoGame(String numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(n -> new LottoNumber(n))
                .collect(Collectors.toList());
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(ILLEGAL_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<LottoNumber> numbers) {
        HashSet<LottoNumber> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != SIZE) {
            throw new IllegalArgumentException(NUMBER_DUPLICATE.getMessage());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
