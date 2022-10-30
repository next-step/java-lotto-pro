package lotto.controller.acceptor;

import lotto.model.money.to.buy.MoneyToBuy;
import lotto.view.DemandMoneyToBuyInputPrinter;

import java.util.Scanner;

public class MoneyToBuyAcceptor {
    public MoneyToBuy accept() {
        DemandMoneyToBuyInputPrinter.print();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new MoneyToBuy(input);
    }
}
