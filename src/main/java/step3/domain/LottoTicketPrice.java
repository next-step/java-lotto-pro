package step3.domain;

public class LottoTicketPrice {

    Money totalPrice;

    public LottoTicketPrice(Money totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public int getTicketCount() {
        final int UNIT_TICKET_PRICE = 1000;
        return (int) (this.totalPrice.getPrice() / UNIT_TICKET_PRICE);
    }

}
