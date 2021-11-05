package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class FourMatch extends Policy {
  public FourMatch() {
    super(50000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (lotto.matchCount(latestWinLotto).equals(4)) {
      return true;
    }

    return false;
  }
}
