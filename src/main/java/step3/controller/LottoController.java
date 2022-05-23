package step3.controller;

import java.util.List;
import java.util.Map;
import step3.domain.LottoTicket;
import step3.domain.Money;
import step3.enums.LottoReward;
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

        int ticketCount = getTicketCountByMoney(); /*정상 값을 입력할때까지 반복입력*/
        int manualTicketCount = getManualTicketCount(ticketCount);
        int randomTicketCount = ticketCount - manualTicketCount;

        List<LottoTicket> manualLottoTickets = makeManualLottoTickets(manualTicketCount);
        List<LottoTicket> randomLottoTickets = lottoMachine.makeRandomLottoTickets(
            randomTicketCount);

        lottoTickets.addLottoTickets(manualLottoTickets);
        lottoTickets.addLottoTickets(randomLottoTickets);

        outputView.printLottoInfo(lottoTickets.getLottoNumbers(), manualTicketCount,
            randomTicketCount);

        setWinnerLotto(); /*정상 값을 입력할때까지 반복입력*/
        setBonusNumber(); /*정상 값을 입력할때까지 반복입력*/

        Map<LottoReward, Integer> matchCountStatistics = lottoMachine.checkWin(
            lottoTickets.getLottoTickets());
        Map<String, String> matchLottoResult = lottoMachine.checkMatchLottoResult(matchCountStatistics,
            ticketCount);
        outputView.printOutput(matchCountStatistics, matchLottoResult);
    }

    private int getTicketCountByMoney() {
        String money = inputView.getMoney();
        try {
            return lottoMachine.getLottoTicketCount(new Money(money));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTicketCountByMoney();
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

    private int getManualTicketCount(int ticketCount) {
        try {
            int manualTicketCount = NumberUtil.parseInt(inputView.getManualTicketCount());
            lottoMachine.validateManualLottoCount(ticketCount, manualTicketCount);
            return manualTicketCount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualTicketCount(ticketCount);
        }
    }

    private List<LottoTicket> makeManualLottoTickets(int ticket) {
        try {
            List<String> manualLottoTicketsSource = inputView.getManualLotto(ticket);
            return lottoMachine.makeManualLottoTickets(manualLottoTicketsSource);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeManualLottoTickets(ticket);
        }
    }
}
