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

  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }

  @Override
  public String toString() {
    StringBuilder lottoTicketsString = new StringBuilder();
    this.lottoTickets.forEach(lottoTicket ->
        lottoTicketsString.append(lottoTicket).append("\n"));
    return lottoTicketsString.toString();
  }
}
