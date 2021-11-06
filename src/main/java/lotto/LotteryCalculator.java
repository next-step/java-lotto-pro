package lotto;

public class LotteryCalculator {
    public static final int LOTTO_TICKET_UNIT_PRICE = 1000;

    public static int calculateTicket(int money) {
            return money/LOTTO_TICKET_UNIT_PRICE;
    }
}
