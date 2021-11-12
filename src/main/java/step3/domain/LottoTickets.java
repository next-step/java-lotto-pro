package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

  private final List<LottoTicket> lottoTickets = new ArrayList<>();

  public LottoTickets(int ticketCount) {
    for (int i = 0; i < ticketCount; i++) {
      this.lottoTickets.add(new LottoTicket());
    }
  }

  public List<LottoTicket> getLottoTickets() {
    return lottoTickets;
  }

  @Override
  public String toString() {
    StringBuilder lottoTicketsString = new StringBuilder();
    this.lottoTickets.forEach(lottoTicket ->
        lottoTicketsString.append(lottoTicket.getNumbers()).append("\n"));
    return lottoTicketsString.toString();
  }
}
