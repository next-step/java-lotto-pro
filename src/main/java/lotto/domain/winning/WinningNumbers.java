package lotto.domain.winning;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final LottoTicket winningNumbers;

    public WinningNumbers(Set<LottoNumber> winningNumbers) {
        this.winningNumbers = new LottoTicket(winningNumbers);
    }

    public WinningNumbers(List<Integer> numbers) {
        this(numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toSet()));
    }

    public int matchCount(Set<LottoNumber> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(this::matchNumber)
                .count();
    }

    public boolean matchNumber(LottoNumber lottoNumber) {
        return winningNumbers.isContains(lottoNumber);
    }

    public boolean isContains(int bonusNumber) {
        return winningNumbers.getLottoNumbers().stream()
                .anyMatch(winningNumber -> winningNumber.getLottoNumber() == bonusNumber);
    }

    public Set<LottoNumber> getWinningNumbers() {
        return Collections.unmodifiableSet(winningNumbers.getLottoNumbers());
    }
}
