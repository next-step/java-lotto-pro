package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class SixMatch extends Policy {
  public SixMatch() {
    super(2000000000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (lotto.matchCount(latestWinLotto).equals(6)) {
      return true;
    }

    return false;
  }
}
