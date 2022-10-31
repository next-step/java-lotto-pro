package lotto.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum RankCode {
  FIRST(6, 2000_000_000),
  SECOND(5, 1_500_000),
  THIRD(4, 50_000),
  FORTH(3, 5_000),
  NOTHING(0, 0);

  private final int containsCount;
  private final int money;

  RankCode(int containsCount, int money) {
    this.containsCount = containsCount;
    this.money = money;
  }

  public static RankCode getRankCode(int matchingCount) {
    return Arrays.stream(RankCode.values())
        .filter(rankCode -> rankCode.containsCount == matchingCount)
        .findAny()
        .orElse(NOTHING);
  }

  public static int getMoney(RankCode rankCode) {
    return RankCode.valueOf(rankCode.name()).money;
  }

  public static int containsCount(RankCode rankCode) {
    return RankCode.valueOf(rankCode.name()).containsCount;
  }
}
