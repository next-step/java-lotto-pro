package step3.domain;

import java.util.Objects;

public class Ticket {

    private final int ticket;
    private final int LOTTO_PRICE = 1_000;
    private final String CANT_BUY_LOTTO_EXCEPTION = "돈은 최소 " + LOTTO_PRICE + "이상 입력해야합니다";

    public Ticket(Money money) {
        if (validateTicket(money)) {
            throw new IllegalArgumentException(CANT_BUY_LOTTO_EXCEPTION);
        }
        this.ticket = money.getMoney() / LOTTO_PRICE;
    }

    private boolean validateTicket(Money money) {
        return money == null || money.getMoney() / LOTTO_PRICE <= 0;
    }

    public Money ticketToMoney() {
        return new Money(ticket * LOTTO_PRICE);
    }

    public int getTicket() {
        return ticket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket1 = (Ticket) o;
        return ticket == ticket1.ticket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
