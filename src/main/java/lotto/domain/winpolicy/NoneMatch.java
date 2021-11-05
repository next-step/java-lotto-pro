package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class NoneMatch extends Policy {
  public NoneMatch() {
    super(0);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (lotto.matchCount(latestWinLotto) < 3) {
      return true;
    }

    return false;
  }
}
