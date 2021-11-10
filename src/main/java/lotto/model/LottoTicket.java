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
    for (int i = LottoRank.THREE_MATCHES.getRank(); i <= LottoRank.SIX_MATCHES.getRank(); i++) {
      MatchResult matchResult = new MatchResult(LottoRank.valueOf(i), new MatchCount(0));
      countingWinningResultsByOrder(winningLottoNumbers, matchResult);
      matchResults.add(matchResult);
    }

    return new MatchResults(matchResults);
  }

  private void countingWinningResultsByOrder(LottoNumbers winningLottoNumbers, MatchResult matchResult) {
    for (LottoNumbers lottoNumbers : lottoTicket) {
      countMatching(winningLottoNumbers, matchResult, lottoNumbers);
    }
  }

  private void countMatching(LottoNumbers winningLottoNumbers, MatchResult matchResult, LottoNumbers lottoNumbers) {
    if (matchResult.isWin(lottoNumbers.countMatchNumber(winningLottoNumbers))) {
      matchResult.addCount();
    }
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
