package step3.model.machine;

import step3.model.value.ErrMsg;

public class Order {

    private final int autoCount;
    private final int manualCount;

    public Order(final int ticketCount, final  int manualCount) {
        if(manualCount>ticketCount){
            throw new IllegalArgumentException(ErrMsg.ORDER_OVER_MONEY_LIMIT);
        }
        this.manualCount = manualCount;
        this.autoCount = ticketCount-manualCount;
    }

    public long getTotalPrice(int ticketPrice){
        return (long) (manualCount+autoCount) * ticketPrice;
    }



    public int getAutoTicketCount() {
        return autoCount;
    }

    public int getManualTicketCount() {
        return manualCount;
    }

}
