package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

  @ParameterizedTest
  @CsvSource(value = {"14000 : 14", "1000 : 1", "4300 : 4"}, delimiter = ':')
  @DisplayName("구입 금액에 따른 로또 티켓 갯수 테스트")
  void lottoTicketCountTest(Long purchasePrice, int ticketCount) {
    LottoTicketPrice money = new LottoTicketPrice(new Money(purchasePrice));
    assertThat(money.getTicketCount()).isEqualTo(ticketCount);
  }

  @ParameterizedTest
  @CsvSource(value = {"100 : 1000: 0.1", "5000 : 14000 : 0.35714287"}, delimiter = ':')
  void winningProfitTest(Long winningPrice, Long purchasePrice, float profit) {
    Money lottoWinningPrice = new Money() {
      @Override
      public Long getPrice() {
        return winningPrice;
      }
    };
    Money lottoTicketPrice = new Money() {
      @Override
      public Long getPrice() {
        return purchasePrice;
      }
    };

    LottoWinningProfit lottoWinningProfit = lottoWinningPrice.getProfitOf(lottoTicketPrice);
    assertEquals(profit, lottoWinningProfit.getProfit());
  }
}
