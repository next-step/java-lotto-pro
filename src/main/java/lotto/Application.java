package lotto;

import lotto.controller.LottoController;
import lotto.domain.AutoLottoIssuer;
import lotto.domain.LottoRandomFactory;
import lotto.domain.RandomNumberMachine;
import lotto.view.View;

public class Application {
    static final int LOTTO_NUMBER_SIZE = 6;

    public static void main(String[] args) {

        AutoLottoIssuer autoLottoIssuer = new AutoLottoIssuer(
                new LottoRandomFactory(new RandomNumberMachine(), LOTTO_NUMBER_SIZE));

        LottoController controller = new LottoController(new View(), autoLottoIssuer);

        controller.start();
    }
}
