package lotto.model;

import lotto.constants.LottoRank;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
  private final List<LottoNumbers> lottoTicket;

  public LottoTicket(List<LottoNumbers> lottoTicket) {
    this.lottoTicket = lottoTicket;
  }

  public MatchResults totalWinningResults(LottoNumbers winningLottoNumbers, int bonusNumber) {
    Map<LottoRank, Integer> matchResults = countMatchResults(winningLottoNumbers, bonusNumber);

    return new MatchResults(getMatchResultList(matchResults));
  }

  private List<MatchResult> getMatchResultList(Map<LottoRank, Integer> matchResults) {
    List<MatchResult> matchResults1 = new ArrayList<>();
    for (LottoRank lottoRank : matchResults.keySet()) {
      matchResults1.add(new MatchResult(lottoRank, new MatchCount(matchResults.get(lottoRank))));
    }

    return matchResults1;
  }

  private Map<LottoRank, Integer> countMatchResults(LottoNumbers winningLottoNumbers, int bonusNumber) {
    Map<LottoRank, Integer> matchResults = getLottoRankIntegerMap();

    for (LottoNumbers lottoNumbers : lottoTicket) {
      int matchCount = lottoNumbers.countOfMatch(winningLottoNumbers);
      if (!isRankIn(matchCount)) continue;

      LottoRank lottoRank = LottoRank.valueOf(matchCount, lottoNumbers.hasBonusNumber(bonusNumber));
      matchResults.put(lottoRank, matchResults.get(lottoRank) + 1);
    }
    return matchResults;
  }

  private Map<LottoRank, Integer> getLottoRankIntegerMap() {
    Map<LottoRank, Integer> matchResults = new EnumMap<>(LottoRank.class);

    for (LottoRank lottoRank : LottoRank.values()) {
      matchResults.put(lottoRank, 0);
    }
    return matchResults;
  }

  private boolean isRankIn(int matchCount) {
    return matchCount >= LottoRank.FIFTH.getRank();
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
    if (matchResult.isWin(lottoNumbers.countOfMatch(winningLottoNumbers))) {
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
