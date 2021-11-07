package lotto.domain.winpolicy;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;

public enum WinPolicy {
  NONE_MATCH(new NoneMatch(), -1),
  THREE_MATCH(new ThreeMatch(), 3),
  FOUR_MATCH(new FourMatch(), 4),
  FIVE_MATCH(new FiveMatch(), 5),
  FIVE_BONUS_MATCH(new FiveAndBonusMatch(), 5),
  SIX_MATCH(new SixMatch(), 6);

  private final Policy policy;
  private final Integer matchCount;

  WinPolicy(Policy policy, Integer matchCount) {
    this.policy = policy;
    this.matchCount = matchCount;
  }

  public Policy getPolicy() {
    return this.policy;
  }

  public Integer getMatchCount() {
    return this.matchCount;
  }

  public Integer getWinPrice() {
    return policy.getWinPrice();
  }

  public Integer getMatchCount(Lotto latestWinLotto, Lottos buyLottos, LottoNumber lottoNumber) {
    return this.policy.getMatchCount(latestWinLotto, buyLottos, lottoNumber);
  }
}
