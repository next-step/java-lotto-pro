package lotto.model;

import lotto.view.ResultView;

import java.util.List;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusBall;
    private final WinningStatus winningStatus;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        this.lotto = new Lotto(numbers);
        this.winningStatus = new WinningStatus();

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

        winningStatus.recordResults(count);
    }

    public int findWinningCount(MatchPoint matchPoint) {
        return winningStatus.findWinningCount(matchPoint);
    }

    public double findEarningsRate(long lottosTotalPrice) {
        return  winningStatus.findEarningsRate(lottosTotalPrice);
    }
}
