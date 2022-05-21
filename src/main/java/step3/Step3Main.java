package step3;

import step3.controller.LottoController;
import step3.model.LottoGenerator;
import step3.model.LottoMachine;
import step3.model.LottoWinChecker;
import step3.view.InputView;
import step3.view.OutputView;

public class Step3Main {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController(
            new LottoMachine(new LottoGenerator(), new LottoWinChecker()),
            new InputView(),
            new OutputView()
        );
        lottoController.startLotto();
    }

}
