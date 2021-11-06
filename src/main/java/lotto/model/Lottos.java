package lotto.model;

import lotto.constants.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
  private final List<Lotto> lottos;

  public Lottos(List<Lotto> lottos) {
    this.lottos = lottos;
  }

  public MatchResults totalWinningResults(Lotto winningLotto) {
    List<MatchResult> matchResults = new ArrayList<>();
    for (int i = LottoRank.THREE_MATCHES.getRank(); i <= LottoRank.SIX_MATCHES.getRank(); i++) {
      MatchResult matchResult = new MatchResult(LottoRank.valueOf(i), new MatchCount(0));
      countingWinningResultsByOrder(winningLotto, matchResult);
      matchResults.add(matchResult);
    }

    return new MatchResults(matchResults);
  }

  private void countingWinningResultsByOrder(Lotto winningLotto, MatchResult matchResult) {
    for (Lotto lotto : lottos) {
      countMatching(winningLotto, matchResult, lotto);
    }
  }

  private void countMatching(Lotto winningLotto, MatchResult matchResult, Lotto lotto) {
    if (matchResult.isWin(lotto.countMatchNumber(winningLotto))) {
      matchResult.addCount();
    }
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    for (Lotto lotto : lottos) {
      stringBuilder.append(lotto.toString());
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }
}
