package lotto.domain.statistics;

import lotto.domain.lotto.LottoNumber;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.lotto.LottoTicket.LOTTO_NUMBER_SIZE;

public class WinningNumbers {

    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(Set<LottoNumber> winningNumbers) {
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(List<Integer> numbers) {
        this(numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet()));
    }

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 6개의 중복되지 않는 숫자 입니다.");
        }
    }

    public boolean matchNumber(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
