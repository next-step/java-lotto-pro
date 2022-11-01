package step3.service;

import java.util.List;
import step3.domain.LottoVendingMachine;
import step3.domain.Lottos;
import step3.domain.Money;
import step3.domain.Rewards;
import step3.domain.WinningLottoNumber;
import step3.view.ConsoleInputView;
import step3.view.ConsoleOutputView;

public class LottoService {
    private final LottoVendingMachine lottoVendingMachine;
    private final Money LOTTO_PRICE = new Money(1000L);

    public LottoService(final LottoVendingMachine lottoVendingMachine) {
        this.lottoVendingMachine = lottoVendingMachine;
    }

    public void execute() {
        Money paidByUser = new Money(ConsoleInputView.receivePurchaseAmount());
        Lottos lottos = buyLottos(paidByUser);
        WinningLottoNumber winningLottoNumber = receiveWiningLottoNumber();
        Rewards rewards = lottos.check(winningLottoNumber);
        ConsoleOutputView.printRewards(rewards);
    }

    private Lottos buyLottos(Money paidByUser) {
        Lottos manualLottos = lottoVendingMachine.buy(paidByUser, receiveManualLottoNumbers());
        Money change = paidByUser.pay(LOTTO_PRICE.multiply(manualLottos.getHasLottoSize()));
        Lottos autoLottos = lottoVendingMachine.buy(change);
        ConsoleOutputView.printLottosCount(manualLottos.getHasLottoSize(), autoLottos.getHasLottoSize());
        Lottos lottos = manualLottos.merge(autoLottos);
        ConsoleOutputView.printLottos(lottos);
        return lottos;
    }

    private WinningLottoNumber receiveWiningLottoNumber() {
        return new WinningLottoNumber(ConsoleInputView.receiveWinningNumber(), ConsoleInputView.receiveBonusNumber());
    }

    private List<String> receiveManualLottoNumbers() {
        int purchaseCount = ConsoleInputView.receiveManualLottoCount();
        return ConsoleInputView.receiveManualLottoNumbers(purchaseCount);
    }
}
