package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private List<LottoTicket> lottoTickets = new ArrayList<>();

  public LottoTickets(int ticketCount) {
    for (int i = 0; i < ticketCount; i++) {
      this.lottoTickets.add(new LottoTicket());
    }
  }

  public LottoTickets(List<LottoTicket> lottoTicketList) {
    this.lottoTickets = lottoTicketList;
  }

  public static LottoMatchCaseEnum calculateMatchCase(LottoTicket sourceTicket,
      LottoWinningTicket winningTicket) {
    int matchCount = (int) sourceTicket.getNumbers().stream()
        .filter(winningTicket::contains)
        .count();
    boolean matchBonus = sourceTicket.contains(winningTicket.getBonusNumber());
    return LottoMatchCaseEnum.valueOf(matchCount, matchBonus);
  }

  public List<LottoTicket> getLottoTickets() {
    return this.lottoTickets;
  }

  public LottoMatchResult matchWinningNumbers(LottoWinningTicket winningTicket) {
    LottoMatchResult lottoMatchResult = new LottoMatchResult();
    this.lottoTickets.forEach(lottoTicket -> {
      LottoMatchCaseEnum matchCaseEnum = calculateMatchCase(lottoTicket, winningTicket);
      lottoMatchResult.addMatchCountNum(matchCaseEnum);
    });
    return lottoMatchResult;
  }
}
