package lotto.controller.acceptor;

import lotto.model.lotto.ticket.LottoNumber;
import lotto.view.DemandBonusInputPrinter;

import java.util.Scanner;

public class BonusAcceptor {
    public LottoNumber accept() {
        DemandBonusInputPrinter.print();
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        return new LottoNumber(input);
    }
}
