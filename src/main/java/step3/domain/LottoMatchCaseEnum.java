package step3.domain;

import java.util.Arrays;

public enum LottoMatchCaseEnum {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int matchCount;
  private final int price;

  LottoMatchCaseEnum(int matchCount, int price) {
    this.matchCount = matchCount;
    this.price = price;
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getPrice() {
    return price;
  }

  public static LottoMatchCaseEnum valueOf(int matchCount, boolean matchBonus) {
    if (matchCount < 3) {
      return MISS;
    }
    if (matchCount == 3) {
      return FIFTH;
    }
    if (matchCount == 4) {
      return FOURTH;
    }
    if (matchCount == 5) {
      return matchBonus ? SECOND : THIRD;
    }
    if (matchCount == 6) {
      return FIRST;
    }
    throw new IllegalArgumentException(String.format(
            "[ERROR] No MatchCase for matchCount = %d, matchBonus = %b", matchCount, matchBonus));
  }
}
