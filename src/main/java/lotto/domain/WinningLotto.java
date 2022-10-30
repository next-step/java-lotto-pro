package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    public WinningLotto(List<LottoNumber> insertWinningLotto) {
        super(insertWinningLotto);
    }

    public int getCorrectCount(Lotto lotto) {
        return this.numbers.getCorrectCount(lotto.numbers);
    }
}
