package step3.model.machine;

public class Order {

    private final int ticketCount;

    public Order(final int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public long getTotalPrice(int ticketPrice){
        return (long) ticketCount * ticketPrice;
    }

    @Override
    public String toString() {
        return Integer.toString(ticketCount);
    }

    public int getAutoTicketCount() {
        return ticketCount;
    }
}
