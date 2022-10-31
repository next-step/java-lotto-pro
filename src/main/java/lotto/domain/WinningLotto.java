package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private final Number bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validWinningLotto(numbers, bonusNumber);
        this.bonusNumber = Number.from(bonusNumber);
    }

    private static void validWinningLotto(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨번호와 다른 숫자를 입력해야 합니다.");
        }
    }

    private boolean isMatchBonus(Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }

    public LottoRank checkResult(Lotto lotto) {
        return LottoRank.valueOf(this.getMatchCount(lotto), isMatchBonus(lotto));
    }

}
