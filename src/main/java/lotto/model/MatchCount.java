package lotto.model;

public class MatchCount {
  private final int matchCount;

  public MatchCount(int matchCount) {
    this.matchCount = matchCount;
  }

  public MatchCount increment() {
    return new MatchCount(matchCount + 1);
  }

  public int getMatchCount() {
    return matchCount;
  }
}
