package lotto.view;

import lotto.model.money.to.buy.MoneyToBuy;

public class NumberOfLottoTicketsPrinters {
    private static final String NUMBER_OF_AFFORDABLE_LOTTO_TICKETS_MESSAGE = "개를 구매했습니다.";

    public static void print(MoneyToBuy moneyToBuy) {
        System.out.println(moneyToBuy.affordableTicketCount() + NUMBER_OF_AFFORDABLE_LOTTO_TICKETS_MESSAGE);
    }
}
