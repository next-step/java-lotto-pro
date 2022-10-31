package step3.model.machine;

import step3.model.util.InputValidation;

public class Money {
    private final int money;
    public Money(String money){
        InputValidation.validateEmpty(money);
        InputValidation.validateNumber(money);
        this.money = Integer.parseInt(money);
    }
    public int availableTicketCount(int ticketPrice){
        return money/ticketPrice;
    }

}
