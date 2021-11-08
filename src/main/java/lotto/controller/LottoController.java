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

        Lottos lottos = lottoGenerator.createLottos(money.getLottoCount());
        outputView.printLottoCount(money.getLottoCount());
        outputView.printLottos(lottos);

        Lotto winningLotto = getWinningLotto();
        WinningNumber winningNumber = getWinningNumber(winningLotto);

        LottoResult lottoResult = new LottoResult(lottos.getLottos(), winningNumber);
        OutputView.printLottoResult(lottoResult);
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
            return lottoGenerator.createWinningNumber(inputView.inputWiningLotto());
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
