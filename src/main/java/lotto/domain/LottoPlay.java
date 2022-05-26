package lotto.domain;

import java.util.List;
import java.util.function.Supplier;
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
        return retryUntilNoException(() -> {
            int money = inputView.inputMoneyForPurchase();
            return new PurchaseMoney(money);
        });
    }

    private PurchaseQuantity getPurchaseQuantity(PurchaseMoney purchaseMoney) {
        return retryUntilNoException(() -> {
            int manualQuantity = inputView.inputManualQuantity();
            return new PurchaseQuantity(purchaseMoney, manualQuantity);
        });
    }

    private Lottos getPurchasedLottos(PurchaseQuantity purchaseQuantity) {
        return retryUntilNoException(() -> {
            List<Lotto> manualList = getManualLottoList(purchaseQuantity);
            return lottoGenerator.generateLottos(manualList, purchaseQuantity.getAutoQuantity());
        });
    }

    private List<Lotto> getManualLottoList(PurchaseQuantity purchaseQuantity) {
        List<String> numbersStrings = inputView.inputManualLottoNumbers(purchaseQuantity);
        return numbersStrings.stream().map(Lotto::new).collect(Collectors.toList());
    }

    private WinningLotto getWinningLotto() {
        return retryUntilNoException(() -> new WinningLotto(getLastWeekLotto(), getBonusLottoNumber()));
    }

    private Lotto getLastWeekLotto() {
        String numbersString = inputView.inputReferenceLottoNumbers();
        return new Lotto(numbersString);
    }

    private LottoNumber getBonusLottoNumber() {
        int bonusNumber = inputView.inputBonusLottoNumber();
        return new LottoNumber(bonusNumber);
    }

    public <T> T retryUntilNoException(Supplier<T> supplier) {
        T value = null;

        while (value == null) {
            try {
                value = supplier.get();
            } catch (IllegalArgumentException e) {
                resultView.printExceptionMessage(e);
            }
        }

        return value;
    }
}
