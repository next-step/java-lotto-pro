package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class FiveAndBonusMatch extends Policy {
  public FiveAndBonusMatch() {
    super(30_000_000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto, LottoNumber bonusNumber) {
    if (latestWinLotto.matchCountOf(lotto).equals(5) && lotto.containLottoNumber(bonusNumber)) {
      return true;
    }

    return false;
  }
}
