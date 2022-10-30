package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> insertWinningLotto) {
        super(insertWinningLotto);
    }

    public WinningLotto(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        this(insertWinningLotto);
        this.bonusBall = bonusBall;
    }

    public int getCorrectCount(Lotto lotto) {
        return this.numbers.getCorrectCount(lotto.numbers);
    }
}
