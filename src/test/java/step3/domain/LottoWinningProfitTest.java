package step3.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoWinningProfitTest {

  @ParameterizedTest
  @CsvSource(value = {"100 : 1000: 0.1", "5000 : 14000 : 0.35714287"}, delimiter = ':')
  void winningProfitTest(Long winningPrice, int purchasePrice, float profit) {
    LottoWinningPrice lottoWinningPrice = new LottoWinningPrice() {
      @Override
      public Long getWinningPrice() {
        return winningPrice;
      }
    };
    LottoTicketsPrice lottoTicketsPrice = new LottoTicketsPrice() {
      @Override
      public int getTicketsPrice() {
        return purchasePrice;
      }
    };

    LottoWinningProfit lottoWinningProfit = lottoWinningPrice.getWinningProfit(lottoTicketsPrice);
    assertEquals(profit, lottoWinningProfit.getProfit());
  }
}
