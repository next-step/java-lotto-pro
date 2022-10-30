package lotto.controller;

import static lotto.view.InputView.printBonusLottoDirection;
import static lotto.view.InputView.printPurchasingLottoDirection;
import static lotto.view.InputView.printWinningLottoDirection;
import static lotto.view.InputView.readLine;
import static lotto.view.ResultView.printExceptionErrorMessage;
import static lotto.view.ResultView.printLottoResults;
import static lotto.view.ResultView.printPurchasingLottoCount;
import static lotto.view.ResultView.printPurchasingLottos;

import common.utils.IntegerUtils;
import common.utils.LongUtils;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.ReadLineLottoNumberGenerator;

public class LottoController {

    public LottoController() {
    }

    public void process() {
        Lottos lottos = createLottos(getMoney());
        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusLottoNumber = getBonusLottoNumber(winningLotto);
        getLottoResults(lottos, winningLotto, bonusLottoNumber);
    }

    private Money getMoney() {
        printPurchasingLottoDirection();
        try {
            String readMoney = readLine();
            return Money.createLottoMoney(LongUtils.parseLong(readMoney));
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return getMoney();
        }
    }

    private Lottos createLottos(Money money) {
        printPurchasingLottoCount(money.maxLottoCount());
        Lottos lottos = new Lottos(money, new RandomLottoNumberGenerator());
        printPurchasingLottos(lottos.unmodifiedLottos());
        return lottos;
    }

    private Lotto getWinningLotto() {
        printWinningLottoDirection();
        try {
            return Lotto.generateLotto(new ReadLineLottoNumberGenerator(readLine()));
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return getWinningLotto();
        }
    }

    private LottoNumber getBonusLottoNumber(Lotto winningLotto) {
        printBonusLottoDirection();
        try {
            String readLottoNumber = readLine();
            return LottoNumber.fromIfNotIn(IntegerUtils.parseInt(readLottoNumber), winningLotto);
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return getBonusLottoNumber(winningLotto);
        }
    }

    private void getLottoResults(Lottos lottos, Lotto winningLotto, LottoNumber bonusLottoNumber) {
        printLottoResults(lottos.createLottoResults(winningLotto, bonusLottoNumber), lottos.findTotalPrice());
    }
}
