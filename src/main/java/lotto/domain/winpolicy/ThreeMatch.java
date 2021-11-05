package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class ThreeMatch extends Policy {
  public ThreeMatch() {
    super(5000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (lotto.matchCount(latestWinLotto).equals(3)) {
      return true;
    }

    return false;
  }

}
