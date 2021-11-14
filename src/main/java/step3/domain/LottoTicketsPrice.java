package step3.domain;

public class LottoTicketsPrice {

  private final int UNIT_TICKET_PRICE = 1000;
  private int purchasePrice;

  public LottoTicketsPrice() {
  }

  public LottoTicketsPrice(int purchasePrice) {
    validate(purchasePrice);
    this.purchasePrice = purchasePrice - purchasePrice % UNIT_TICKET_PRICE;
  }

  public int getTicketCount() {
    return this.purchasePrice / UNIT_TICKET_PRICE;
  }

  public int getTicketsPrice() {
    return this.purchasePrice;
  }

  private void validate(int purchasePrice) {
    if (purchasePrice < 0) {
      throw new RuntimeException("[ERROR] price cannot be negative. purchasePrice =" + purchasePrice);
    }
  }
}
