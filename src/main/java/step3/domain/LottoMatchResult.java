package step3.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

  final private Map<LottoMatchCaseEnum, Integer> matchCountMap = new HashMap<>();

  public LottoMatchResult() {
  }

  public int getMatchCountNum(LottoMatchCaseEnum matchCaseEnum) {
    return matchCountMap.get(matchCaseEnum) != null ? matchCountMap.get(matchCaseEnum) : 0;
  }

  public void addMatchCountNum(LottoMatchCaseEnum matchCaseEnum) {
    this.matchCountMap.put(matchCaseEnum, getMatchCountNum(matchCaseEnum) + 1);
  }

  public LottoWinningPrice getLottoWinningPrice() {
    Long winningPrice = Arrays.stream(LottoMatchCaseEnum.values())
        .mapToLong(lottoMatchCase ->
            (long) lottoMatchCase.getPrice() * this.getMatchCountNum(lottoMatchCase))
        .sum();

    return new LottoWinningPrice(winningPrice);
  }

}
