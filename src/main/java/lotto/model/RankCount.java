package lotto.model;

import java.util.Objects;

public class RankCount {
  private final int rankCount;

  public RankCount(int rankCount) {
    this.rankCount = rankCount;
  }

  public RankCount addCount(int count) {
    return new RankCount(rankCount + count);
  }

  public int getRankCount() {
    return rankCount;
  }

  @Override
  public String toString() {
    return String.valueOf(rankCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RankCount rankCount1 = (RankCount) o;
    return rankCount == rankCount1.rankCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rankCount);
  }

}