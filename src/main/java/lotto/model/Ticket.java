package lotto.model;

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
}
