package step3.controller;

import java.util.List;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.model.LottoMachine;
import step3.model.LottoTickets;
import step3.utls.NumberUtil;
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
        LottoTickets lottoTickets = new LottoTickets();

        int ticket = getTicketByMoney(); /*정상 값을 입력할때까지 반복입력*/
        int manualTicket = getManualLottoCount(ticket);
        int randomTicket = ticket - manualTicket;

        List<LottoTicket> manualLottoTickets = getManualLottoTickets(manualTicket);
        List<LottoTicket> randomLottoTickets = lottoMachine.makeRandomLottoTickets(randomTicket);
        lottoTickets.addLottoTickets(manualLottoTickets);
        lottoTickets.addLottoTickets(randomLottoTickets);
        outputView.printLottoInfo(lottoTickets.getLottoNumbers(), manualTicket, randomTicket);

        setWinnerLotto(); /*정상 값을 입력할때까지 반복입력*/
        setBonusNumber(); /*정상 값을 입력할때까지 반복입력*/

        outputView.printOutput(lottoMachine.checkWin(lottoTickets.getLottoTickets()), lottoMachine.getUsingMoneyByTicket(ticket));
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
            String winnerLottoTicketElements = inputView.getWinnerLotto();
            lottoMachine.setWinnerLottoTicket(winnerLottoTicketElements);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setWinnerLotto();
        }
    }

    private void setBonusNumber() {
        try {
            String bonusNumberElement = inputView.getBonusLotto();
            lottoMachine.setBonusNumber(bonusNumberElement);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBonusNumber();
        }
    }

    private int getManualLottoCount(int ticket) {
        try {
            int manualLottoCount = NumberUtil.parseInt(inputView.getManualLottoCount());
            lottoMachine.validateManualLottoCount(ticket, manualLottoCount);
            return manualLottoCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLottoCount(ticket);
        }
    }

    private List<LottoTicket> getManualLottoTickets(int ticket) {
        try {
            List<String> manualLottoTicketsSource = inputView.getManualLotto(ticket);
            return lottoMachine.makeManualLottoTickets(manualLottoTicketsSource);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLottoTickets(ticket);
        }
    }
}
