package lotto.model.winning;

import java.util.Objects;
import java.util.Optional;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumber;
import lotto.type.LottoRank;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String[] lottoNumberArr, int bonusNumber) {
        this.winningLotto = Lotto.of(lottoNumberArr);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public Optional<LottoRank> match(Lotto lotto) {
        int matchCount = this.winningLotto.match(lotto);
        boolean matchBonus = lotto.contains(bonusNumber);
        return LottoRank.rankMatch(matchCount, matchBonus);
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
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusNumber,
            that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusNumber);
    }

}
