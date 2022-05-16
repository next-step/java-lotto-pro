package step3.controller;

import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.model.LottoMachine;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    private final LottoMachine lottoMachine;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoMachine lottoMachine, InputView inputView, OutputView outputView) {
        this.lottoMachine = lottoMachine;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startLotto() {
        Money money = null;
        while (money == null) {
            String moneySource = inputView.getMoney();
            money = lottoMachine.createMoney(moneySource);
        }

        lottoMachine.buyTicket(money);
        outputView.printLottoInfo(lottoMachine.getLottoNumbers());

        LottoTicket winnerTicket = null;
        while (winnerTicket == null) {
            String manualLottoSource = inputView.getWinnerLotto();
            winnerTicket = lottoMachine.makeManualLottoTicket(manualLottoSource);
        }

        outputView.printOutput(lottoMachine.checkWin(winnerTicket), money);
    }


}
