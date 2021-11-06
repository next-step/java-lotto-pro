package lotto.model;

import lotto.constants.LottoRank;

import java.util.Objects;

public class MatchResult {
  private final LottoRank lottoRank;
  private MatchCount matchCount;

  public MatchResult(LottoRank lottoRank, MatchCount matchCount) {
    this.lottoRank = lottoRank;
    this.matchCount = matchCount;
  }

  public void addCount() {
    this.matchCount = matchCount.increment();
  }

  public boolean isWin(int rank) {
    return lottoRank.getRank() == rank;
  }

  public LottoRank getLottoRank() {
    return lottoRank;
  }

  public int getMatchCount() {
    return matchCount.getMatchCount();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MatchResult that = (MatchResult) o;
    return lottoRank == that.lottoRank;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoRank);
  }
}
