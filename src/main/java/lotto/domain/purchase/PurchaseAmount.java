package lotto.domain.purchase;

public class PurchaseAmount {

    private final int autoTicketAmount;

    public PurchaseAmount(int ticketAmount) {
        this.autoTicketAmount = ticketAmount;
    }

    public int getAutoTicketAmount() {
        return autoTicketAmount;
    }
}
