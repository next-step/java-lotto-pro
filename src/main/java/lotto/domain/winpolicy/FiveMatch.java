package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class FiveMatch extends Policy {
  public FiveMatch() {
    super(1_500_000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto, LottoNumber bonusNumber) {
    if (latestWinLotto.matchCountOf(lotto).equals(5) && !lotto.containLottoNumber(bonusNumber)) {
      return true;
    }

    return false;
  }
}
