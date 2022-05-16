package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    private static final int DEFAULT_NUMBER_SIZE = 6;
    private final List<LottoNumber> winningNumbers;
    private final int lottoNumberSize;

    public WinningNumbers(LottoNumber[] winningNumbers) {
        this.lottoNumberSize = DEFAULT_NUMBER_SIZE;
        this.winningNumbers = Arrays.asList(winningNumbers);
        validateNumbersCount();
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

    private void validateNumbersCount() {
        if (lottoNumberSize != this.winningNumbers.size()) {
            throw new IllegalArgumentException(String.format("당첨번호는 %d자리 숫자이어야 합니다.", lottoNumberSize));
        }
    }

    private boolean hasDuplicatedLottoNumber() {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(this.winningNumbers);
        return this.winningNumbers.size() != lottoNumberSet.size();
    }
}
