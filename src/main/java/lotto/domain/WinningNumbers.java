package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private final List<LottoNumber> winningNumbers;

    public WinningNumbers(LottoNumber[] winningNumbers) {
        this.winningNumbers = Arrays.asList(winningNumbers);
        validateDuplicated();
    }

    public MatchResult matchWinningLotto(Lotto lotto) {
        return lotto.match(winningNumbers);
    }

    private void validateDuplicated() {
        if (hasDuplicatedLottoNumber()) {
            throw new IllegalArgumentException("당첨번호는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private boolean hasDuplicatedLottoNumber() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(this.winningNumbers);
        return this.winningNumbers.size() != lottoNumberSet.size();
    }
}
