package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

  static final public int MATCH_COUNT_MIN = 3;
  static final public int MATCH_COUNT_MAX = 6;

  final private Map<Integer, Integer> matchCountMap = new HashMap<>();

  public LottoMatchResult() {
  }

  public LottoMatchResult(LottoTickets lottoTickets, LottoTicket winningTicket) {
    lottoTickets.getLottoTickets().forEach(lottoTicket -> {
      int matchCount = calculateMatchCount(lottoTicket, winningTicket);
      if (matchCount >= MATCH_COUNT_MIN) {
        matchCountMap.put(matchCount, getMatchCountNum(matchCount) + 1);
      }
    });
  }

  public static int calculateMatchCount(LottoTicket sourceTicket, LottoTicket targetTicket) {
    return (int) sourceTicket.getNumbersAsInteger().stream()
        .filter(winningNumber -> targetTicket.getNumbersAsInteger().contains(winningNumber))
        .count();
  }

  public int getMatchCountNum(int matchCount) {
    return matchCountMap.get(matchCount) != null ? matchCountMap.get(matchCount) : 0;
  }
}
