package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
  private static final int ZERO = 0;

  private final Map<LottoRank, RankCount> winningResult;

  private WinningResult(Map<LottoRank, RankCount> winningResult) {
    this.winningResult = winningResult;
  }

  public static WinningResult init() {
    Map<LottoRank, RankCount> winningResult = new EnumMap<>(LottoRank.class);

    for (LottoRank lottoRank : LottoRank.values()) {
      winningResult.put(lottoRank, new RankCount(ZERO));
    }

    return new WinningResult(winningResult);
  }

  public void addResult(LottoRank lottoRank, int rankCount) {
    winningResult.computeIfPresent(lottoRank, (lottoRank1, rankCount1) -> rankCount1.addCount(rankCount));
  }

  public Map<LottoRank, RankCount> getWinningResult() {
    return winningResult;
  }

  public double calculateYield(PurchaseAmount purchaseAmount) {
    return winningResult.keySet()
      .stream()
      .mapToLong(key -> (long) key.getReward() * winningResult.get(key).getRankCount())
      .sum() / (double) purchaseAmount.getPurchaseAmount();
  }

}