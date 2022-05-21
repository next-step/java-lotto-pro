package lotto.model.winning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.LottoNumber;
import lotto.type.LottoRank;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Set<Integer> lottoNumberSet, int bonusNumber) {
        if(lottoNumberSet.contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복된 보너스 볼은 사용할 수 없습니다.");
        }

        this.winningLotto = Lotto.fromInteger(lottoNumberSet);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinningLotto(List<Integer> lottoNumberList, int bonusNumber) {
        this(new HashSet<>(lottoNumberList), bonusNumber);
    }

    public LottoRank match(Lotto lotto) {
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
