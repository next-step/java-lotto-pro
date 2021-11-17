package step3.domain;

public class Money {
  private Long price;

  public Money() {
  }

  public Money(Long price) {
    validate(price);
    this.price = price;
  }

  public Long getPrice() {
    return this.price;
  }

  private void validate(Long price) {
    if (price < 0) {
      throw new IllegalArgumentException("[ERROR] price cannot be negative. price =" + price);
    }
  }

  public LottoWinningProfit getProfitOf(Money money) {
    // 당첨금(winning price), 티켓구입금액(ticketsPrice) -> 이율 계산
    float profit = (float) this.getPrice() / money.getPrice();
    return new LottoWinningProfit(profit);
  }
}
