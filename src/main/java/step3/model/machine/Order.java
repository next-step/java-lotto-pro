package step3.model.machine;

public class Order {

    private final int ticketCount;

    public Order(final int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public boolean leftToTicketing(int ticketNumber) {
        return ticketCount>ticketNumber;
    }
    public long getTotalPrice(int ticketPrice){
        return ticketCount*ticketPrice;
    }

    @Override
    public String toString() {
        return ticketCount+"개를 구매했습니다.";
    }
}
