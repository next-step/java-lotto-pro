package step3.domain;

import java.util.ArrayList;
import java.util.List;
import step3.enums.Rule;

public class Lotto {

    private LottoNumber lottoNumber;

    private int matchCount;

    private boolean hasBonusNumber;

    public Lotto() {
    }

    public List<Integer> gainAutoNumbers() {
        Range range = new Range(Rule.TOTAL_START_NUMBER.getRange(), Rule.TOTAL_END_NUMBER.getRange());
        lottoNumber = new LottoNumber();
        return lottoNumber.gainSixAutoLottoNumbers(range);
    }

    public void match(WinningLotto winningLotto) {
        this.hasBonusNumber = lottoNumber.hasBonusNumber(winningLotto.getBonusNumber());
        List<Integer> copy = new ArrayList<>(lottoNumber.getLottoNumber());
        copy.retainAll(winningLotto.getWinningNumber().getLottoNumber());
        this.matchCount = copy.size();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }

}
