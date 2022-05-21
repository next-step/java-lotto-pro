package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WinningLotto {
    private final Set<LottoNumber> winningNumbers;
    private LottoNumber bonusNumber;

    public WinningLotto(LottoNumber[] winningNumbers, LottoNumber bonusNumber) {
        validateDuplicated(winningNumbers, bonusNumber);
        this.winningNumbers = new HashSet<>(Arrays.asList(winningNumbers));
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(String[] winningNumbers, String bonusNumber) {
        this(createWinningLottoNumbers(winningNumbers), LottoNumber.from(bonusNumber));
    }

    private static LottoNumber[] createWinningLottoNumbers(String[] numbers) {
        LottoNumber[] winningNumbers = new LottoNumber[numbers.length];
        for (int index = 0; index < winningNumbers.length; index++) {
            winningNumbers[index] = LottoNumber.from(numbers[index]);
        }
        return winningNumbers;
    }

    public boolean isMatched(Lotto lotto, MatchResult matchResult) {
        return matchWinningLotto(lotto).equals(matchResult);
    }

    private MatchResult matchWinningLotto(Lotto lotto) {
        return lotto.match(winningNumbers, bonusNumber);
    }

    private void validateDuplicated(LottoNumber[] winningNumbers, LottoNumber bonusNumber) {
        if (hasDuplicatedLottoNumber(winningNumbers, bonusNumber)) {
            throw new IllegalArgumentException("당첨번호는 중복된 숫자를 가질 수 없습니다.");
        }
    }

    private boolean hasDuplicatedLottoNumber(LottoNumber[] numbers, LottoNumber bonusNumber) {
        Set<LottoNumber> nonDuplicatedNumbers = new HashSet<>(Arrays.asList(numbers));
        nonDuplicatedNumbers.add(bonusNumber);

        return nonDuplicatedNumbers.size() != numbers.length + 1;
    }


}
