package step3.domain;

public class LottoTicketsPrice {

  private final int UNIT_TICKET_PRICE = 1000;
  private int purchasePrice;
  private int actualPurchasePrice;

  public LottoTicketsPrice() {
  }

  public LottoTicketsPrice(int purchasePrice) {
    this.purchasePrice = purchasePrice;
    this.actualPurchasePrice = purchasePrice - purchasePrice % UNIT_TICKET_PRICE;
  }

  public int getTicketCount() {
    return this.purchasePrice / UNIT_TICKET_PRICE;
  }

  public int getTicketsPrice() {
    return this.actualPurchasePrice;
  }
}
