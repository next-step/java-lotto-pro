package step3.controller;

import java.util.Scanner;
import step3.domain.Lotto;
import step3.domain.LottoQuantity;
import step3.domain.Lottos;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoController {

    private static final Scanner scanner = new Scanner(System.in);

    public void doLotto() {
        InputView.printRequestAmountMessage();
        String amount = scanner.nextLine();
        LottoQuantity quantity = getLottoQuantity(amount);
        ResultView.printLottoQuantityMessage(quantity);
        Lottos lottos = getLottos(quantity);
        ResultView.printLottosNumberMessage(lottos);
    }

    private LottoQuantity getLottoQuantity(String amount) {
        int value = Integer.parseInt(amount);
        return LottoQuantity.of(value);
    }

    private Lottos getLottos(LottoQuantity quantity) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < quantity.getQuantity(); i++) {
            lottos.add(Lotto.generate());
        }
        return lottos;
    }
}
