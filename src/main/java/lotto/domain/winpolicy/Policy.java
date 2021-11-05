package lotto.domain.winpolicy;

import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

public abstract class Policy {
  protected final Integer winPrice;

  protected Policy(Integer winPrice) {
    this.winPrice = winPrice;
  }

  public abstract Boolean isMatch(Lotto latestWinLotto, Lotto lotto);

  public Integer getMatchCount(Lotto latestWinLotto, Lottos lottos) {
    Integer count = 0;

    for (Integer i = 0; i < lottos.size(); i++) {
      if (isMatch(latestWinLotto, lottos.get(i))) {
        count++;
      }
    }

    return count;
  }

  public Integer getWinPrice() {
    return this.winPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }

    if (!(o instanceof Policy)) {
      return false;
    }

    Policy winPolicy = (Policy) o;
    return Objects.equals(winPrice, winPolicy.winPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(winPrice);
  }

}
