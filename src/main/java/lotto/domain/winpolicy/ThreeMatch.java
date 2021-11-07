package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class ThreeMatch extends Policy {
  public ThreeMatch() {
    super(5_000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto, LottoNumber bonusNumber) {
    if (latestWinLotto.matchCountOf(lotto).equals(3)) {
      return true;
    }

    return false;
  }

}
