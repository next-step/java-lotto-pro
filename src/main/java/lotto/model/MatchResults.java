package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class MatchResults {
  private final List<MatchResult> matchResults;

  public MatchResults(List<MatchResult> matchResults) {
    this.matchResults = matchResults;
  }

  public long getTotalWinningAmount() {
    long sum = 0;
    for (MatchResult matchResult : matchResults) {
      sum += matchResult.calculateWinningAmount();
    }
    return sum;
  }

  public double calculateYield(PurchaseAmount purchaseAmount) {
    return purchaseAmount.calculateYield(getTotalWinningAmount());
  }

  public List<MatchResult> getMatchResults() {
    return new ArrayList<>(matchResults);
  }
}
