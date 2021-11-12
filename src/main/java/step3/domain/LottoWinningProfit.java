package step3.domain;

public class LottoWinningProfit {

  private final float profit;

  public LottoWinningProfit(LottoWinningPrice winningPrice, LottoTicketsPrice ticketsPrice) {
    // 당첨금(winning price), 티켓구입금액(ticketsPrice) -> 이율 계산
    this.profit = (float) winningPrice.getWinningPrice() / ticketsPrice.getTicketsPrice();
  }

  public float getProfit() {
    return this.profit;
  }
}
