package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoWinningPrice {

  // key: matchCount, value: winningPrice
  static final public Map<Integer, Integer> MATCH_COUNT_WINNING_PRICE_MAP = new HashMap<Integer, Integer>() {{
    put(3, 5_000);
    put(4, 50_000);
    put(5, 1_500_000);
    put(6, 2_000_000_000);
  }};
  // 당첨금, 단위: 원
  private int winningPrice;
  private LottoMatchResult lottoMatchResult;

  public LottoWinningPrice() {
  }

  public LottoWinningPrice(LottoMatchResult lottoMatchResult) {
    this.lottoMatchResult = lottoMatchResult;

    // lotto result -> winning price 계산
    MATCH_COUNT_WINNING_PRICE_MAP.forEach((matchCount, price) ->
        this.winningPrice += price * lottoMatchResult.getMatchCountNum(matchCount));
  }

  public int getWinningPrice() {
    return this.winningPrice;
  }

  public LottoMatchResult getLottoMatchResult() {
    return lottoMatchResult;
  }

  @Override
  public String toString() {
    StringBuilder winningResult = new StringBuilder();
    for (int matchCount = LottoMatchResult.MATCH_COUNT_MIN;
        matchCount <= LottoMatchResult.MATCH_COUNT_MAX; matchCount++) {
      winningResult.append(String.format("%d개 일치 (%d원)- %d\n",
          matchCount,
          MATCH_COUNT_WINNING_PRICE_MAP.get(matchCount),
          this.lottoMatchResult.getMatchCountNum(matchCount)));
    }
    return winningResult.toString();
  }
}
