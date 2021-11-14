package lotto.model;

import lotto.constants.LottoRank;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
  private final List<LottoNumbers> lottoTicket;

  public LottoTicket(List<LottoNumbers> lottoTicket) {
    this.lottoTicket = lottoTicket;
  }

  public MatchResults totalWinningResults(LottoNumbers winningLottoNumbers) {
    List<MatchResult> matchResults = new ArrayList<>();
    for (int i = LottoRank.FIFTH.getRank(); i <= LottoRank.FIRST.getRank(); i++) {
      MatchResult matchResult = new MatchResult(LottoRank.valueOf(i), new MatchCount(0));
      matchResult.addMatchCount(countingWinningResultsByOrder(winningLottoNumbers, matchResult));
      matchResults.add(matchResult);
    }

    return new MatchResults(matchResults);
  }

  private int countingWinningResultsByOrder(LottoNumbers winningLottoNumbers, MatchResult matchResult) {
    int count = 0;
    for (LottoNumbers lottoNumbers : lottoTicket) {
      count += countMatching(winningLottoNumbers, matchResult, lottoNumbers);
    }

    return count;
  }

  private int countMatching(LottoNumbers winningLottoNumbers, MatchResult matchResult, LottoNumbers lottoNumbers) {
    if (matchResult.isWin(lottoNumbers.countMatchNumber(winningLottoNumbers))) {
      return 1;
    }

    return 0;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();

    for (LottoNumbers lottoNumbers : lottoTicket) {
      stringBuilder.append(lottoNumbers.toString());
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }
}
