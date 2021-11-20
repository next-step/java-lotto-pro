package step3.domain;

import java.util.Arrays;

public enum LottoMatchCaseEnum {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  MISS(0, false, 0);

  private final int matchCount;
  private final boolean matchBonus;
  private final int price;

  LottoMatchCaseEnum(int matchCount, boolean matchBonus, int price) {
    this.matchCount = matchCount;
    this.matchBonus = matchBonus;
    this.price = price;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getPrice() {
    return price;
  }

  private static boolean isMiss(int matchCount) {
    return matchCount < LottoMatchCaseEnum.FIFTH.matchCount;
  }

  private boolean isSameValueOf(int matchCount, boolean matchBonus) {
    if (matchCount == SECOND.getMatchCount()) {
      return this.matchCount == matchCount && this.matchBonus == matchBonus;
    }
    return this.matchCount == matchCount;
  }

  public static LottoMatchCaseEnum valueOf(int matchCount, boolean matchBonus) {
    if (isMiss(matchCount)) {
      return MISS;
    }

    return Arrays.stream(LottoMatchCaseEnum.values())
        .filter(matchCaseEnum -> matchCaseEnum.isSameValueOf(matchCount, matchBonus))
        .findAny()
        .orElseThrow(() ->
            new IllegalArgumentException(String.format(
                "[ERROR] No MatchCase for matchCount = %d, matchBonus = %b", matchCount,
                matchBonus)));
  }
}
