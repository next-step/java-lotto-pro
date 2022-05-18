package step3.domain;

import java.util.List;

public class WinnerLotto {
    private final Lotto lotto;

    public WinnerLotto(List<Integer> winnerNumbers) {
        this.lotto = LottoFactory.createManualLotto(winnerNumbers);
    }

    public List<LottoNumber> lottoNumbers() {
        return lotto.sortedLottoNumbers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerLotto that = (WinnerLotto) o;
        return lotto.equals(that.lotto);
    }

    @Override
    public int hashCode() {
        return lotto.hashCode();
    }
}
