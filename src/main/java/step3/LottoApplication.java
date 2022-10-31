package step3;

import step3.controller.LottoController;
import step3.model.machine.ShuffleLottoGenerator;
import step3.model.machine.LottoAutoGenerator;

public class LottoApplication {

    public static void main(String[] args) {
        LottoAutoGenerator ticketGenerator = new ShuffleLottoGenerator();
        LottoController lottoController = new LottoController(ticketGenerator);
        lottoController.start();
    }

}
