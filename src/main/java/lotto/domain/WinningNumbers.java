package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private final Set<LottoNumber> winningNumbers;

    public WinningNumbers(LottoNumber[] winningNumbers) {
        validateDuplicated(winningNumbers);
        this.winningNumbers = new HashSet<>(Arrays.asList(winningNumbers));
    }

    public MatchResult matchWinningLotto(Lotto lotto) {
        return lotto.match(winningNumbers);
    }

    private void validateDuplicated(LottoNumber[] winningNumbers) {
        if (hasDuplicatedLottoNumber(winningNumbers)) {
            throw new IllegalArgumentException("당첨번호는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private boolean hasDuplicatedLottoNumber(LottoNumber[] numbers) {
        Set<LottoNumber> nonDuplicatedNumbers = new HashSet<>(Arrays.asList(numbers));
        return nonDuplicatedNumbers.size() != numbers.length;
    }
}
