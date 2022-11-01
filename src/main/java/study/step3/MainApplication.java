package study.step3;

import study.step3.controller.LottoController;
import study.step3.controller.LottoMachineController;
import study.step3.domain.lotto.RandomLottoIssuanceStrategy;
import study.step3.view.ConsoleMainView;

public class MainApplication {

    public static void main(String[] args) {
        LottoMachineController lottoMachineController = new LottoMachineController(new RandomLottoIssuanceStrategy());
        LottoController lottoController = new LottoController();

        ConsoleMainView consoleMainView = new ConsoleMainView(lottoMachineController, lottoController);
        consoleMainView.render();
    }
}
