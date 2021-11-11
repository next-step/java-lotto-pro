package lotto.domain;

import java.util.Objects;

public class TicketAmount {
    private int ticketAmount;

    public TicketAmount(int ticketAmount) {
        this.ticketAmount = ticketAmount;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketAmount that = (TicketAmount) o;
        return ticketAmount == that.ticketAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketAmount);
    }
}
