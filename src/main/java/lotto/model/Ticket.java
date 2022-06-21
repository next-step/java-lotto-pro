package lotto.model;

import java.util.Objects;

public class Ticket {
    private static final int UNIT = 1000;

    private int ticket;

    public Ticket(Money money) {
        ticket = money.value() / UNIT;
    }

    public void use(int minus) {
        ticket -= minus;
    }

    public int size() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket1 = (Ticket) o;
        return ticket == ticket1.ticket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket=" + ticket +
                '}';
    }
}
