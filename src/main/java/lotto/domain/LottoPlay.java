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
        Lottos lottos = lottoGenerator.generateLottos(purchaseMoney.getAmountOfLotto());
        resultView.printPurchasedLottos(lottos);
        Lotto referenceLotto = getReferenceLotto();
        LottosResults results = lottos.matchWithReference(referenceLotto);
        resultView.printLottoStatisticsResult(results, purchaseMoney);
    }

    private PurchaseMoney getPurchaseMoney() {
        Integer money = inputView.inputMoneyForPurchase();
        return new PurchaseMoney(money);
    }

    private Lotto getReferenceLotto() {
        String lottoNumberString = inputView.inputReferenceLottoNumbers();
        List<Integer> numberList = StringUtil.splitNumbersString(lottoNumberString, ",");
        return new Lotto(numberList.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }
}
