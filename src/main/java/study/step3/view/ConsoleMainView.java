package study.step3.view;

import study.step3.controller.LottoController;
import study.step3.controller.LottoMachineController;
import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lottostatistics.LottoStatistics;

public class ConsoleMainView {

    private final LottoMachineController lottoMachineController;
    private final LottoController lottoController;

    public ConsoleMainView(LottoMachineController lottoMachineController, LottoController lottoController) {
        this.lottoMachineController = lottoMachineController;
        this.lottoController = lottoController;
    }

    public void render() {
        PurchaseMoney purchaseMoney = lottoMachineController.inputPurchaseMoney();
        Lottos lottos = lottoMachineController.issueLottos(purchaseMoney);
        LottoView.printLottos(lottos);

        LottoStatistics lottoStatistics = lottoController.match(purchaseMoney, lottos);
        LottoStatisticsView.printLottoStatistics(lottoStatistics);
    }
}
