package lotto.domain;

import java.util.Objects;

public class BonusBall {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public BonusBall(final Lotto winningLotto, final LottoNumber bonusLottoNumber) {
        verifyBonusBall(winningLotto, bonusLottoNumber);

        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private void verifyBonusBall(final Lotto winningLotto, final LottoNumber lottoNumber) {
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalArgumentException("지난 주 당첨 번호를 이미 있는 번호입니다.");
        }
    }

    public boolean matchBy(final Lotto purchasedLotto) {
        return purchasedLotto.contains(this.bonusLottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BonusBall)) {
            return false;
        }
        BonusBall bonusBall = (BonusBall)o;
        return Objects.equals(winningLotto, bonusBall.winningLotto) &&
            Objects.equals(bonusLottoNumber, bonusBall.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusLottoNumber);
    }
}
