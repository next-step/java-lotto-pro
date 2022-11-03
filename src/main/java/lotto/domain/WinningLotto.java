package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateBonusNumber();
    }

    public WinningLotto(List<Integer> lottoNumbers, LottoNumber bonusNumber) {
        this(new Lotto(lottoNumbers),bonusNumber);
    }

    public WinningLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
        this(new Lotto(lottoNumbers),LottoNumber.of(bonusNumber));
    }

    public boolean hasSameNumber(LottoNumber lottoNumber) {
        return lotto.hasSameNumber(lottoNumber);
    }

    public boolean hasBonus(LottoNumber lottoNumber) {
        if (Objects.isNull(bonusNumber)) {
            return false;
        }
        return bonusNumber.equals(lottoNumber);
    }

    private void validateBonusNumber() {
        if (lotto.hasSameNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호에 포함되지 않은 번호를 선택해야 합니다");
        }
    }
}
