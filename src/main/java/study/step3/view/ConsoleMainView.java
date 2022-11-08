package study.step3.view;

import study.step3.controller.LottoController;
import study.step3.controller.LottoMachineController;
import study.step3.domain.lotto.Lotto;
import study.step3.domain.lotto.Lottos;
import study.step3.domain.lotto.PurchaseMoney;
import study.step3.domain.lotto.WinningLotto;
import study.step3.domain.lottonumber.LottoNumber;
import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.lottostatistics.LottoStatistics;

import java.util.List;

public class ConsoleMainView {

    private final LottoMachineController lottoMachineController;
    private final LottoController lottoController;

    public ConsoleMainView(LottoMachineController lottoMachineController, LottoController lottoController) {
        this.lottoMachineController = lottoMachineController;
        this.lottoController = lottoController;
    }

    public void render() {
        PurchaseMoney purchaseMoney = LottoMachineView.getPurchaseMoney();
        long manualLottoCount = LottoMachineView.getManualLottoCount(purchaseMoney);
        List<LottoNumbers> manualLottoNumbers = LottoView.getManualLottoNumbers(manualLottoCount);
        Lottos lottos = lottoMachineController.issueLottos(purchaseMoney, manualLottoNumbers);
        LottoView.printLottos(manualLottoCount, lottos);

        LottoNumbers winnerNumbers = LottoView.getWinningNumbers();
        LottoNumber bonusNumber = LottoView.getBonusNumber(winnerNumbers);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winnerNumbers), bonusNumber);
        LottoStatistics lottoStatistics = lottoController.match(purchaseMoney, lottos, winningLotto);
        LottoStatisticsView.printLottoStatistics(lottoStatistics);
    }
}
