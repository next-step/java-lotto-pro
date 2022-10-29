package lotto.view;

import lotto.model.money.to.buy.MoneyToBuy;

/**
 * 구입 완료한 로또 장 수를 안내하는 메시지를 출력한다.
 */
public class NumberOfLottoTicketsPrinters {
    private static final String NUMBER_OF_AFFORDABLE_LOTTO_TICKETS_MESSAGE = "개를 구매했습니다.";

    public static void print(MoneyToBuy moneyToBuy) {
        System.out.println(moneyToBuy.numberOfAffordableLottoTickets() + NUMBER_OF_AFFORDABLE_LOTTO_TICKETS_MESSAGE);
    }
}
