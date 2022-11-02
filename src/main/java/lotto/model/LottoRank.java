package lotto.model;

import java.util.Arrays;

public enum LottoRank {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FORTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  NOTHING(0, false, 0);

  private final int containsCount;
  private final boolean isContainBonusNumber;
  private final int money;

  LottoRank(int containsCount, boolean isContainBonusNumber, int money) {
    this.containsCount = containsCount;
    this.isContainBonusNumber = isContainBonusNumber;
    this.money = money;
  }

  public static LottoRank getLottoRank(int containsCount, boolean isContainBonusNumber) {
    return Arrays.stream(LottoRank.values())
        .filter(lottoRank -> lottoRank.containsCount == containsCount
            && lottoRank.isContainBonusNumber == isContainBonusNumber)
        .findAny()
        .orElse(NOTHING);
  }

  public int containsCount() {
    return this.containsCount;
  }

  public int getMoney() {
    return this.money;
  }
}
