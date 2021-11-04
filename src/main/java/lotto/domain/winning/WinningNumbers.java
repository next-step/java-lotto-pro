package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {
    private static final int WINNING_NUMBER_SIZE = 6;

    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(Set<LottoNumber> winningNumbers) {
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(List<Integer> numbers) {
        this(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != WINNING_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개의 중복되지 않는 숫자 입니다.");
        }
    }

    public int matchCount(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this::matchNumber)
                .count();
    }

    public boolean matchNumber(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
