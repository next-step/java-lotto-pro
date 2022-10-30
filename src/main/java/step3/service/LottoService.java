package step3.service;

import static step3.view.ConsoleInputView.receiveBonusNumber;
import static step3.view.ConsoleInputView.receiveWinningNumber;

import step3.domain.LottoVendingMachine;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rewards;
import step3.domain.WinningLottoNumber;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoService {
    private final LottoVendingMachine lottoVendingMachine;

    public LottoService(final LottoVendingMachine lottoVendingMachine) {
        this.lottoVendingMachine = lottoVendingMachine;
    }

    public void execute() {
        Money paidByUser = new Money(ConsoleInputView.receivePurchaseAmount());
        Lottos lottos = lottoVendingMachine.buy(paidByUser);
        ConsoleOutputView.printLottos(lottos);
        WinningLottoNumber winningLottoNumber = new WinningLottoNumber(receiveWinningNumber(), receiveBonusNumber());
        Rewards rewards = winningLottoNumber.check(lottos);
        ConsoleOutputView.printRewards(rewards);
    }
}
