package lotto;

import java.util.Objects;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningLotto {

    private Lotto lotto;
    private LottoNumber bonusLottoNumber;
    
    public WinningLotto(Lotto lotto, LottoNumber bonusLottoNumber) {
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
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
        return Objects.equals(lotto, that.lotto) && Objects.equals(bonusLottoNumber,
            that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto, bonusLottoNumber);
    }
}
