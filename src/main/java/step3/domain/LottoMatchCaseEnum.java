package step3.domain;

import java.util.Arrays;

public enum LottoMatchCaseEnum {
  ZERO_NUMBER_MATCH(0, 0),
  ONE_NUMBER_MATCH(1, 0),
  TWO_NUMBERS_MATCH(2, 0),
  THREE_NUMBERS_MATCH(3, 5_000),
  FOUR_NUMBERS_MATCH(4, 50_000),
  FIVE_NUMBERS_MATCH(5, 1_500_000),
  SIX_NUMBERS_MATCH(6, 2_000_000_000);

  private final int matchCount;
  private final int price;

  LottoMatchCaseEnum(int matchCount, int price) {
    this.matchCount = matchCount;
    this.price = price;
  }

  public static LottoMatchCaseEnum value(int matchCount) {
    return Arrays.stream(LottoMatchCaseEnum.values())
        .filter(matchCaseEnum -> matchCaseEnum.getMatchCount() == matchCount)
        .findAny()
        .orElse(null);
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getPrice() {
    return price;
  }
}
