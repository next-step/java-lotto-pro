package step3.controller;

import java.util.List;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.model.LottoMachine;
import step3.model.LottoUser;
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
        LottoUser user = new LottoUser();

        int ticket = getTicketByMoney(); /*정상 값을 입력할때까지 반복입력*/

        List<LottoTicket> lottoTickets = lottoMachine.makeRandomLottoTickets(ticket);
        user.setUserLotto(lottoTickets);
        outputView.printLottoInfo(user.getLottoNumbers());

        setWinnerLotto(); /*정상 값을 입력할때까지 반복입력*/
        setBonusNumber(); /*정상 값을 입력할때까지 반복입력*/

        outputView.printOutput(lottoMachine.checkWin(user.getLottoTickets()), lottoMachine.getUsingMoneyByTicket(ticket));
    }

    private int getTicketByMoney() {
        String money = inputView.getMoney();
        try {
            return lottoMachine.getLottoTicketCount(new Money(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTicketByMoney();
        }
    }

    private void setWinnerLotto() {
        try {
            String winnerLottoSource = inputView.getWinnerLotto();
            lottoMachine.setWinnerLottoTicket(winnerLottoSource);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinnerLotto();
        }
    }

    private void setBonusNumber() {
        try {
            String bonusNumberSource = inputView.getBonusLotto();
            lottoMachine.setBonusNumber(bonusNumberSource);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }

    }

}
