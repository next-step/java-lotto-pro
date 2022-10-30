package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningLotto(List<Integer> lottoNumbers, LottoNumber bonusNumber) {
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }
    public WinningLotto(List<Integer> lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = null;
    }

    public boolean hasSameNumber(LottoNumber lottoNumber) {
        return lotto.hasSameNumber(lottoNumber);
    }

    public boolean hasBonus(LottoNumber lottoNumber) {
        if(Objects.isNull(bonusNumber)){
            return false;
        }
        return bonusNumber.equals(lottoNumber);
    }
}
