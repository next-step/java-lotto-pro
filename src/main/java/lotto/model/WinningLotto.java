package lotto.model;

import lotto.view.ResultView;

import java.util.List;

public class WinningLotto extends WinningStatus {

    private final Lotto lotto;
    private final LottoNumber bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        super();
        this.lotto = new Lotto(numbers);

        if(isDuplicationNumber(numbers, bonusBall)) {
            throw new IllegalArgumentException(ResultView.ERROR_DUPLICATION_NUMBER);
        }
        this.bonusBall = new LottoNumber(bonusBall);
    }

    private boolean isDuplicationNumber(List<Integer> numbers, int bonusBall) {
        return numbers.stream().anyMatch(number -> number == bonusBall);
    }

    public void compareWinningLotto(Lotto lotto) {
        int count = lotto.findMatchCount(this.lotto);
        boolean matchBonus = lotto.isMatchBonus(this.bonusBall);

        recordResults(count, matchBonus);
    }
}
