package lotto;

public class LotteryCalculator {
    public static final int LOTTO_TICKET_UNIT_PRICE = 1000;

    public static int calculateTicket(Money money) {
        return money.getNumberOfTicket(LOTTO_TICKET_UNIT_PRICE);
    }
}
