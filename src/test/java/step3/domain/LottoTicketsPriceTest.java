package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTicketsPriceTest {

  @ParameterizedTest
  @CsvSource(value = {"14000 : 14", "1000 : 1", "4300 : 4"}, delimiter = ':')
  @DisplayName("구입 금액에 따른 로또 티켓 갯수 테스트")
  void lottoTicketCountTest(int purchasePrice, int ticketCount) {
    LottoTicketsPrice lottoTicketsPrice = new LottoTicketsPrice(purchasePrice);
    assertThat(lottoTicketsPrice.getTicketCount()).isEqualTo(ticketCount);
  }
}
