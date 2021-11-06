package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class SixMatch extends Policy {
  public SixMatch() {
    super(2_000_000_000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (latestWinLotto.matchCountOf(lotto).equals(6)) {
      return true;
    }

    return false;
  }
}
