package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class NoneMatch extends Policy {
  public NoneMatch() {
    super(0);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto, LottoNumber bonusNumber) {
    if (latestWinLotto.matchCountOf(lotto) < 3) {
      return true;
    }

    return false;
  }
}
