package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoGenerator lottoGenerator = new LottoGenerator();

    public void start() {
        Money money = getMoney();

        LottoCount lottoCount = getManualCount(money);
        Lottos manualLottos = getManualLotto(lottoCount.getManualCount());
        Lottos lottos = lottoGenerator.createLottos(lottoCount.getAutoCount(), manualLottos.getLottos());
        outputView.printLottoCount(lottoCount.getManualCount(), lottoCount.getAutoCount());
        outputView.printLottos(lottos);

        Lotto winningLotto = getWinningLotto();
        WinningNumber winningNumber = getWinningNumber(winningLotto);

        LottoResult lottoResult = new LottoResult(lottos.getLottos(), winningNumber);
        OutputView.printLottoResult(lottoResult);
    }

    private Lottos getManualLotto(int manualCount) {
        try {
            return lottoGenerator.createManualLottos(inputView.inputManualLotto(manualCount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLotto(manualCount);
        }
    }

    private LottoCount getManualCount(Money money) {
        try {
            return new LottoCount(inputView.inputManualCountLotto(), money);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualCount(money);
        }
    }

    private WinningNumber getWinningNumber(Lotto winningLotto) {
        try {
            return new WinningNumber(winningLotto, new LottoNumber(inputView.inputBonusBall()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber(winningLotto);
        }
    }

    private Lotto getWinningLotto() {
        try {
            return lottoGenerator.createManualNumber(inputView.inputWiningLotto());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    private Money getMoney() {
        try {
            return new Money(inputView.inputMoney());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }
}
