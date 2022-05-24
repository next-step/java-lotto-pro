package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import util.StringUtil;

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
        Lottos lottos = lottoGenerator.generateLottos(purchaseQuantity.getTotalQuantity());
        resultView.printPurchasedLottos(lottos);
        WinningLotto winningLotto = getWinningLotto();
        LottosResults results = lottos.matchWithWinningLotto(winningLotto);
        resultView.printLottoStatisticsResult(results, purchaseMoney);
    }

    private PurchaseMoney getPurchaseMoney() {
        int money = inputView.inputMoneyForPurchase();
        return new PurchaseMoney(money);
    }

    private PurchaseQuantity getPurchaseQuantity(PurchaseMoney purchaseMoney) {
        int manualQuantity = inputView.inputManualQuantity();
        return new PurchaseQuantity(purchaseMoney, manualQuantity);
    }

    private WinningLotto getWinningLotto() {
        return new WinningLotto(getLastWeekLotto(), getBonusLottoNumber());
    }

    private Lotto getLastWeekLotto() {
        String lottoNumberString = inputView.inputReferenceLottoNumbers();
        List<Integer> numberList = StringUtil.splitNumbersString(lottoNumberString, ",");
        return new Lotto(numberList.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    private LottoNumber getBonusLottoNumber() {
        int bonusNumber = inputView.inputBonusLottoNumber();
        return new LottoNumber(bonusNumber);
    }
}
