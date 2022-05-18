package step3.controller;

import java.util.List;
import step3.domain.LottoTicket;
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
        String money;
        do {
            money = inputView.getMoney();
            user.setMoney(money);
        } while (ticketIsNotValid(user));

        List<LottoTicket> lottoTickets = lottoMachine.makeRandomLottoTickets(user.getTicket());
        user.buyLotto(lottoTickets);
        outputView.printLottoInfo(user.getLottoNumbers());

        String winnerLottoSource;
        do {
            winnerLottoSource = inputView.getWinnerLotto();
        } while (winnerLottoIsNotValid(winnerLottoSource));

        String bonusNumberSource;
        do {
            bonusNumberSource = inputView.getBonusLotto();
        } while (bonusNumberIsNotValid(bonusNumberSource));

        outputView.printOutput(lottoMachine.checkWin(user.getLottoTickets()), user.getTicket());
    }

    private boolean bonusNumberIsNotValid(String bonusNumberSource) {
        return !lottoMachine.setBonusNumber(bonusNumberSource);
    }

    private boolean winnerLottoIsNotValid(String winnerLottoSource) {
        return !lottoMachine.setWinnerLotto(winnerLottoSource);
    }

    private boolean ticketIsNotValid(LottoUser user) {
        return !user.buyTicket();
    }
}
