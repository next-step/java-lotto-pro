package lotto.controller.acceptor;

import lotto.model.money.to.buy.MoneyToBuy;
import lotto.view.DemandMoneyToBuyInputPrinter;
import lotto.view.NumberOfLottoTicketsPrinters;

import java.util.Scanner;

public class MoneyToBuyAcceptor {
    public MoneyToBuy accept() {
        DemandMoneyToBuyInputPrinter.print();
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final MoneyToBuy moneyToBuy = new MoneyToBuy(input);
        NumberOfLottoTicketsPrinters.print(moneyToBuy);
        return moneyToBuy;
    }
}
