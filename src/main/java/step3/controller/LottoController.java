package step3.controller;

import java.util.Scanner;
import step3.domain.LottoQuantity;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {

    private static final Scanner scanner = new Scanner(System.in);

    public void doLotto() {
        InputView.printRequestAmountMessage();
        String amount = scanner.nextLine();
        Integer value = Integer.parseInt(amount);
        ResultView.printLottoQuantityMessage(LottoQuantity.of(value));
    }
}
