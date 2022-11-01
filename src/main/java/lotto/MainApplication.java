package lotto;

import lotto.controller.LottoController;
import lotto.model.lotto.ticket.LottoNumberGenerator;

public class MainApplication {
    public static void main(String[] args) {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final LottoController lottoController = new LottoController(lottoNumberGenerator);
        lottoController.run();
    }
}
