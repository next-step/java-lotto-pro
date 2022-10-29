package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusBall;
    public WinningLotto(final List<Integer> numbers, int bonusNumber) {
        super(numbers);
        bonusBall = new LottoNumber(bonusNumber);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
