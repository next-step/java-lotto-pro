package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;

public class Application {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.run(new LottoMachine());
    }
}
