package lotto.domain.winpolicy;

public enum WinPolicy {
  NONE_MATCH(new NoneMatch()),
  THREE_MATCH(new ThreeMatch()),
  FOUR_MATCH(new FourMatch()),
  FIVE_MATCH(new FiveMatch()),
  SIX_MATCH(new SixMatch());

  private final Policy value;

  WinPolicy(Policy value) {
    this.value = value;
  }

  public Policy getValue() {
    return value;
  }

  public Integer getWinPrice() {
    return value.getWinPrice();
  }

}
