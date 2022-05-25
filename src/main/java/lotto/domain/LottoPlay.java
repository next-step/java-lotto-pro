package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.InputView;
import lotto.ui.ResultView;

public class LottoPlay {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoPlay() {
        inputView = new InputView();
        resultView = new ResultView();
        lottoGenerator = new LottoGenerator();
    }

    public void play() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
        PurchaseQuantity purchaseQuantity = getPurchaseQuantity(purchaseMoney);
        Lottos lottos = getPurchasedLottos(purchaseQuantity);
        resultView.printPurchasedLottos(purchaseQuantity, lottos);
        WinningLotto winningLotto = getWinningLotto();
        LottosResults results = lottos.matchWithWinningLotto(winningLotto);
        resultView.printLottoStatisticsResult(results, purchaseMoney);
    }

    private PurchaseMoney getPurchaseMoney() {
        PurchaseMoney purchaseMoney = null;

        while (purchaseMoney == null) {
            purchaseMoney = getPurchaseMoneyWithoutException();
        }

        return purchaseMoney;
    }

    private PurchaseMoney getPurchaseMoneyWithoutException() {
        PurchaseMoney purchaseMoney = null;

        try {
            int money = inputView.inputMoneyForPurchase();
            purchaseMoney = new PurchaseMoney(money);
        } catch (IllegalArgumentException exception) {
            resultView.printExceptionMessage(exception);
        }

        return purchaseMoney;
    }

    private PurchaseQuantity getPurchaseQuantity(PurchaseMoney purchaseMoney) {
        PurchaseQuantity purchaseQuantity = null;

        while (purchaseQuantity == null) {
            purchaseQuantity = getPurchaseQuantityWithoutException(purchaseMoney);
        }

        return purchaseQuantity;
    }

    private PurchaseQuantity getPurchaseQuantityWithoutException(PurchaseMoney purchaseMoney) {
        PurchaseQuantity purchaseQuantity = null;

        try {
            int manualQuantity = inputView.inputManualQuantity();
            purchaseQuantity = new PurchaseQuantity(purchaseMoney, manualQuantity);
        } catch (IllegalArgumentException exception) {
            resultView.printExceptionMessage(exception);
        }

        return purchaseQuantity;
    }

    private Lottos getPurchasedLottos(PurchaseQuantity purchaseQuantity) {
        Lottos lottos = null;

        while (lottos == null) {
            lottos = getPurchasedLottosWithoutException(purchaseQuantity);
        }

        return lottos;
    }

    private Lottos getPurchasedLottosWithoutException(PurchaseQuantity purchaseQuantity) {
        Lottos lottos = null;

        try {
            List<Lotto> manualList = getManualLottoList(purchaseQuantity);
            lottos = lottoGenerator.generateLottos(manualList, purchaseQuantity.getAutoQuantity());
        } catch (IllegalArgumentException exception) {
            resultView.printExceptionMessage(exception);
        }

        return lottos;
    }

    private List<Lotto> getManualLottoList(PurchaseQuantity purchaseQuantity) {
        List<String> numbersStrings = inputView.inputManualLottoNumbers(purchaseQuantity);
        return numbersStrings.stream().map(Lotto::new).collect(Collectors.toList());
    }

    private WinningLotto getWinningLotto() {
        WinningLotto winningLotto = null;

        while (winningLotto == null) {
            winningLotto = getWinningLottoWithoutException();
        }

        return winningLotto;
    }

    private WinningLotto getWinningLottoWithoutException() {
        WinningLotto winningLotto = null;

        try {
            winningLotto = new WinningLotto(getLastWeekLotto(), getBonusLottoNumber());
        } catch (IllegalArgumentException exception) {
            resultView.printExceptionMessage(exception);
        }

        return winningLotto;
    }

    private Lotto getLastWeekLotto() {
        String numbersString = inputView.inputReferenceLottoNumbers();
        return new Lotto(numbersString);
    }

    private LottoNumber getBonusLottoNumber() {
        int bonusNumber = inputView.inputBonusLottoNumber();
        return new LottoNumber(bonusNumber);
    }
}
