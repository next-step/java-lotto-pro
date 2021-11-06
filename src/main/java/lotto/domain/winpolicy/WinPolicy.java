package lotto.domain.winpolicy;

public enum WinPolicy {
  NONE_MATCH(new NoneMatch()),
  THREE_MATCH(new ThreeMatch()),
  FOUR_MATCH(new FourMatch()),
  FIVE_MATCH(new FiveMatch()),
  SIX_MATCH(new SixMatch());

  private final Policy policy;

  WinPolicy(Policy policy) {
    this.policy = policy;
  }

  public Policy getPolicy() {
    return policy;
  }

  public Integer getWinPrice() {
    return policy.getWinPrice();
  }

}
