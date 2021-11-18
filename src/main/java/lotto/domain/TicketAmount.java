package lotto.domain;

import lotto.exception.IllegalTicketAmountException;
import lotto.exception.NotANumberException;

import java.util.Objects;

public class TicketAmount {
    public static final int ZERO = 0;
    private final int ticketAmount;

    public TicketAmount(int ticketAmount) {
        validateTicketAmount(ticketAmount);
        this.ticketAmount = ticketAmount;
    }

    public static TicketAmount from(String inputCountsOfManualTickets) {
        try {
            return new TicketAmount(Integer.parseInt(inputCountsOfManualTickets));
        } catch (NumberFormatException e) {
            throw new NotANumberException();
        }
    }

    private void validateTicketAmount(int ticketAmount) {
        if (ticketAmount < ZERO) {
            throw new IllegalTicketAmountException();
        }
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
