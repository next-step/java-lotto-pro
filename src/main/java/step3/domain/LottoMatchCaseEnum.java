package step3.domain;

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
    switch (matchCount) {
      case 0:
        return ZERO_NUMBER_MATCH;
      case 1:
        return ONE_NUMBER_MATCH;
      case 2:
        return TWO_NUMBERS_MATCH;
      case 3:
        return THREE_NUMBERS_MATCH;
      case 4:
        return FOUR_NUMBERS_MATCH;
      case 5:
        return FIVE_NUMBERS_MATCH;
      case 6:
        return SIX_NUMBERS_MATCH;
      default:
        return null;
    }
  }

  public int getMatchCount() {
    return this.matchCount;
  }

  public int getPrice() {
    return price;
  }
}
