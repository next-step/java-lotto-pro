package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

  @Test
  @DisplayName("생성한 티켓 목록의 갯수가 의도와 일치한 지 확인")
  void checkLottoTicketsCount() {
    int ticketCount = 100;
    LottoTickets lottoTickets = new LottoTickets(ticketCount);
    assertEquals(lottoTickets.getLottoTickets().size(), ticketCount);
  }
}
