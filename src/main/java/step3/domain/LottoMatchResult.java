package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {

  static final private int MATCH_COUNT_MIN = 3;
  static final private int MATCH_COUNT_MAX = 6;

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

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    for (int matchCount = MATCH_COUNT_MIN; matchCount <= MATCH_COUNT_MAX; matchCount++) {
      result
          .append(String.format("%d개 일치 (5000원)- %d\n", matchCount, getMatchCountNum(matchCount)));
    }
    return result.toString();
  }
}
