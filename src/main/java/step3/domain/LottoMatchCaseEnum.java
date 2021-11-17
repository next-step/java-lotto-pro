package step3.domain;

import java.util.Arrays;

public enum LottoMatchCaseEnum {
  ZERO_NUMBER_MATCH(0, false, 0),
  ONE_NUMBER_MATCH(1, false, 0),
  TWO_NUMBERS_MATCH(2, false, 0),
  THREE_NUMBERS_MATCH(3, false, 5_000),
  FOUR_NUMBERS_MATCH(4, false, 50_000),
  FIVE_NUMBERS_MATCH(5, false, 1_500_000),
  FIVE_NUMBERS_AND_BONUS_MATCH(5, true, 30_000_000),
  SIX_NUMBERS_MATCH(6, false, 2_000_000_000);

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

  public boolean isMatchBonus() {
    return matchBonus;
  }

  public int getPrice() {
    return price;
  }

  public static LottoMatchCaseEnum valueOf(int matchCount, boolean matchBonus) {
    return Arrays.stream(LottoMatchCaseEnum.values())
        .filter(matchCaseEnum -> matchCaseEnum.getMatchCount() == matchCount
            && matchCaseEnum.isMatchBonus() == matchBonus)
        .findAny()
        .orElseThrow(() -> new IllegalArgumentException(String.format(
            "[ERROR] No MatchCase for matchCount = %d, matchBonus = %b", matchCount, matchBonus)));
  }
}
