package lotto.controller.acceptor;

import lotto.model.money.to.buy.MoneyToBuy;
import lotto.view.DemandMoneyToBuyInputPrinter;

import java.util.Scanner;

/**
 * UI 에서 로또 구매할 금액을 입력 받는 객체이다.
 */
public class MoneyToBuyAcceptor {
    public MoneyToBuy accept() {
        DemandMoneyToBuyInputPrinter.print();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new MoneyToBuy(input);
    }
}
