package lotto.model;

import java.util.Arrays;

public enum LottoRank {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  MISS(0, 0);

  private final int matchCount;
  private final int reward;

  LottoRank(int matchCount, int reward) {
    this.matchCount = matchCount;
    this.reward = reward;
  }

  public long calculateReward(RankCount rankCount) {
    return (long) reward * rankCount.getRankCount();
  }

  public static LottoRank valueOf(int matchCount, boolean matchBonus) {
    if (matchCount == SECOND.matchCount && matchBonus) return SECOND;

    return Arrays.stream(values())
      .filter(lottoRank -> lottoRank.matchCount == matchCount)
      .filter(lottoRank -> !lottoRank.equals(SECOND))
      .findAny()
      .orElse(MISS);
  }

  public int getMatchCount() {
    return matchCount;
  }

  public int getReward() {
    return reward;
  }
}