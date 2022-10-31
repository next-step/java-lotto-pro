package lotto.controller;

import static lotto.view.InputView.printBonusLottoDirection;
import static lotto.view.InputView.printManualLottoDirection;
import static lotto.view.InputView.printPurchasingLottoDirection;
import static lotto.view.InputView.printPurchasingManualLottoCountDirection;
import static lotto.view.InputView.printWinningLottoDirection;
import static lotto.view.InputView.readLine;
import static lotto.view.ResultView.printExceptionErrorMessage;
import static lotto.view.ResultView.printLottoResults;
import static lotto.view.ResultView.printPurchasingLottoCount;
import static lotto.view.ResultView.printPurchasingLottos;

import common.utils.IntegerUtils;
import common.utils.LongUtils;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.ReadLineLottoNumberGenerator;
import lotto.domain.WinningLotto;

public class LottoController {

    private static final int ZERO = 0;

    public LottoController() {
    }

    public void process() {
        Lottos purchaseLottos = createLottos(getMoney());
        WinningLotto winningLotto = getWinningLotto();
        getLottoResults(purchaseLottos.createLottoResults(winningLotto), purchaseLottos.findTotalPrice());
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
        int manualLottoCount = getManualLottoCount(money);
        List<Lotto> manualLottos = createManualLottos(manualLottoCount);

        int autoLottoCount = money.maxLottoCountExclude(manualLottoCount);
        printPurchasingLottoCount(autoLottoCount, manualLottoCount);

        Lottos lottos = new Lottos(autoLottoCount, new RandomLottoNumberGenerator(), manualLottos);
        printPurchasingLottos(lottos.unmodifiedLottos());

        return lottos;
    }

    private int getManualLottoCount(Money money) {
        printPurchasingManualLottoCountDirection();
        try {
            String readCount = readLine();
            int manualLottoCount = IntegerUtils.parseInt(readCount);
            money.isBuyableLottoCount(manualLottoCount);
            return manualLottoCount;
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return getManualLottoCount(money);
        }
    }

    private List<Lotto> createManualLottos(int manualLottoCount) {
        if(manualLottoCount == ZERO) {
            return new ArrayList<>();
        }

        printManualLottoDirection();
        try {
            return generateManualLottos(manualLottoCount);
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return createManualLottos(manualLottoCount);
        }
    }

    private List<Lotto> generateManualLottos(int manualLottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for(int count = 0; count < manualLottoCount; count++) {
            lottos.add(Lotto.generateLotto(new ReadLineLottoNumberGenerator(readLine())));
        }
        return lottos;
    }

    private WinningLotto getWinningLotto() {
        Lotto winningLotto = generateWinningLotto();
        LottoNumber bonusLottoNumber = generateBonusLottoNumber(winningLotto);
        return new WinningLotto(winningLotto, bonusLottoNumber);
    }

    private Lotto generateWinningLotto() {
        printWinningLottoDirection();
        try {
            return Lotto.generateLotto(new ReadLineLottoNumberGenerator(readLine()));
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return generateWinningLotto();
        }
    }

    private LottoNumber generateBonusLottoNumber(Lotto winningLotto) {
        printBonusLottoDirection();
        try {
            String readLottoNumber = readLine();
            return LottoNumber.fromIfNotIn(IntegerUtils.parseInt(readLottoNumber), winningLotto);
        } catch (IllegalArgumentException e) {
            printExceptionErrorMessage(e);
            return generateBonusLottoNumber(winningLotto);
        }
    }

    private void getLottoResults(LottoResults lottoResults, Money totalMoney) {
        printLottoResults(lottoResults, totalMoney);
    }
}
