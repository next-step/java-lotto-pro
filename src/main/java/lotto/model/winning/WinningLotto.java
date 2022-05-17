package lotto.model.winning;

import java.util.Objects;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumber;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String[] lottoNumberArr, int bonusNumber) {
        this.lotto = Lotto.of(lottoNumberArr);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusNumber);
    }

}
