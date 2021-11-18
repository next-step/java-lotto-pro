package lotto.domain;

import java.util.Objects;

public class BonusBall {

    private final Lotto winningLotto;
    private final LottoNumber lottoNumber;

    public BonusBall(final Lotto winningLotto, final LottoNumber lottoNumber) {
        this.winningLotto = winningLotto;
        this.lottoNumber = lottoNumber;
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
            Objects.equals(lottoNumber, bonusBall.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, lottoNumber);
    }
}
