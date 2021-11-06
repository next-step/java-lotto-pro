package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;

public class FiveMatch extends Policy {
  public FiveMatch() {
    super(1_500_000);
  }

  @Override
  public Boolean isMatch(Lotto latestWinLotto, Lotto lotto) {
    if (lotto.matchCount(latestWinLotto).equals(5)) {
      return true;
    }

    return false;
  }
}
