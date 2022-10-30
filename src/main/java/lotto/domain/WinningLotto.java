package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private LottoNumber bonusBall;

    public WinningLotto(List<LottoNumber> insertWinningLotto) {
        super(insertWinningLotto);
    }

    public WinningLotto(List<LottoNumber> insertWinningLotto, LottoNumber bonusBall) {
        this(insertWinningLotto);

        if(insertWinningLotto.stream()
                .anyMatch(number -> number.equals(bonusBall))) {
            throw new IllegalArgumentException("로또 번호와 보너스 볼 번호가 중복됩니다.");
        }
        this.bonusBall = bonusBall;
    }

    public int getCorrectCount(Lotto lotto) {
        return this.numbers.getCorrectCount(lotto.numbers);
    }
}
