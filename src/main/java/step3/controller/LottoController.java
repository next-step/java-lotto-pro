package step3.controller;

import static step3.enums.InputStatus.LOTTO;
import static step3.enums.InputStatus.MONEY;

import step3.domain.LottoTicket;
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
        String money = null;
        while (money == null) {
            money = lottoMachine.buyTicket(inputView.getInput(MONEY));
        }

        outputView.printLottoInfo(lottoMachine.getLottoNumbers());

        LottoTicket winnerTicket = null;
        while (winnerTicket == null) {
            winnerTicket = lottoMachine.makeManualLottoTicket(inputView.getInput(LOTTO));
        }

        outputView.printOutput(lottoMachine.checkWin(winnerTicket), Integer.parseInt(money));
    }


}
