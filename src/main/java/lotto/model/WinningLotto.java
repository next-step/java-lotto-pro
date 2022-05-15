package lotto.model;

import lotto.view.ResultView;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        this.lotto = new Lotto(numbers);

        if(isDuplicationNumber(numbers, bonusBall)) {
            throw new IllegalArgumentException(ResultView.ERROR_DUPLICATION_NUMBER);
        }
        this.bonusBall = new LottoNumber(bonusBall);
    }

    private boolean isDuplicationNumber(List<Integer> numbers, int bonusBall) {
        return numbers.stream().anyMatch(number -> number == bonusBall);
    }

    public int compareMatchPointCount(Lotto lotto) {
        return lotto.findMatchCount(this.lotto);
    }

    public boolean isMatchBonus(Lotto lotto) {
        return lotto.isMatchBonus(this.bonusBall);
    }
}
