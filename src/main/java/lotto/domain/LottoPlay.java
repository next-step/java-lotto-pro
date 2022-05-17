package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lotto.ui.InputView;
import lotto.ui.ResultView;
import util.StringUtil;

public class LottoPlay {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoPlay() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void play() {
        PurchaseMoney purchaseMoney = getPurchaseMoney();
        Lottos lottos = genLottos(purchaseMoney);
        resultView.printPurchasedLottos(lottos);
        Lotto referenceLotto = getReferenceLotto();
        LottosResults results = lottos.matchWithReference(referenceLotto);
        resultView.printLottoStatisticsResult(results, purchaseMoney);
    }

    private PurchaseMoney getPurchaseMoney() {
        Integer money = inputView.inputMoneyForPurchase();
        return new PurchaseMoney(money);
    }

    private Lottos genLottos(PurchaseMoney purchaseMoney) {
        int amountOfLotto = purchaseMoney.getAmountOfLotto();
        LottoNumberPool pool = new LottoNumberPool();

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < amountOfLotto; i++) {
            lottoList.add(pool.generateLotto());
        }

        return new Lottos(lottoList);
    }

    private Lotto getReferenceLotto() {
        String lottoNumberString = inputView.inputReferenceLottoNumbers();
        List<Integer> numberList = StringUtil.splitNumbersString(lottoNumberString, ",");
        return new Lotto(numberList.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}
