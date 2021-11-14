package step3.domain;

public class LottoWinningPrice {

  // 당첨금, 단위: 원
  private Long winningPrice;

  public LottoWinningPrice() {
  }

  public LottoWinningPrice(Long winningPrice) {
    validate(winningPrice);
    this.winningPrice = winningPrice;
  }

  public Long getWinningPrice() {
    return this.winningPrice;
  }

  private void validate(Long winningPrice) {
    if (winningPrice < 0) {
      throw new RuntimeException("[ERROR] winning price cannot be negative. price =" + winningPrice);
    }
  }

  public LottoWinningProfit getWinningProfit(LottoTicketsPrice lottoTicketsPrice) {
    // 당첨금(winning price), 티켓구입금액(ticketsPrice) -> 이율 계산
    float profit = (float) this.getWinningPrice() / lottoTicketsPrice.getTicketsPrice();
    return new LottoWinningProfit(profit);
  }
}
