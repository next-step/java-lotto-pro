package lotto.domain.winpolicy;

import java.util.Objects;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;

public abstract class Policy {
  protected final Integer winPrice;

  protected Policy(Integer winPrice) {
    this.winPrice = winPrice;
  }

  public abstract Boolean isMatch(Lotto latestWinLotto, Lotto lotto, LottoNumber bonusNumber);

  public Integer getMatchCount(Lotto latestWinLotto, Lottos lottos, LottoNumber bonusNumber) {
    return lottos.matchCount(this, latestWinLotto, bonusNumber);
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
