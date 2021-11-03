package lotto.domain;

public class TicketAmount {

    private final int autoTicketAmount;

    public TicketAmount(int ticketAmount) {
        this.autoTicketAmount = ticketAmount;
    }

    public int getAutoTicketAmount() {
        return autoTicketAmount;
    }
}
