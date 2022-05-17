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
        int ticket = 0;
        while (moneyAndTicketIsNotValid(money,ticket)) { //돈을 정상적으로 받아올때까지 반복한다
            String moneySource = inputView.getMoney();
            money = lottoMachine.insertMoney(moneySource);
            ticket = lottoMachine.buyTicket(money);
        }

        outputView.printLottoInfo(lottoMachine.getLottoNumbers());

        LottoTicket winnerTicket = null;
        while (winnerTicket == null) { //우승 티켓을 정상적으로 받아올때까지 반복한다
            String manualLottoSource = inputView.getWinnerLotto();
            winnerTicket = lottoMachine.makeManualLottoTicket(manualLottoSource);
        }

        outputView.printOutput(lottoMachine.checkWin(winnerTicket), money);
    }

    private boolean moneyAndTicketIsNotValid(Money money,int ticket){
        return money == null || ticket == 0;
    }
}
