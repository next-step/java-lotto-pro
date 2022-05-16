package lotto.controller;

import lotto.config.AppConfig;
import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.service.LottoIssuedService;
import lotto.utils.ListUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final static String LOTTO_NUMBER_TEXT_SPLIT_VALUE = ", ";

    private final LottoIssuedService lottoIssuedService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        AppConfig appConfig = new AppConfig();
        inputView = appConfig.inputView();
        resultView = appConfig.resultView();
        lottoIssuedService = appConfig.lottoIssuedService();
    }

    public void play() {
        inputView.printInputPurchasePrice();
        String purchasePriceText = inputView.inputPurchasePrice();
        int purchaseCount = purchaseLotto(purchasePriceText);

        Lottos lottos = issueLottos(lottoIssuedService, purchaseCount);

        Lotto lastWeekLotto = lastWeekLotto();

        lottoResult(lottos, lastWeekLotto);
    }

    private int purchaseLotto(String purchasePriceText) {
        LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
        int purchaseCount = lottoPurchase.purchaseCount();
        resultView.printPurchaseLottoCount(purchaseCount);

        return purchaseCount;
    }

    private Lottos issueLottos(LottoIssuedService lottoIssuedService, int purchaseCount) {
        Lottos lottos = new Lottos(lottoIssuedService, purchaseCount);
        resultView.printIssuedLottoNumber(lottos);

        return lottos;
    }

    private Lotto lastWeekLotto() {
        inputView.printInputLastWeekWinningNumber();
        String lastWeekLottoNumberText = inputView.inputLastWeekWinningNumber();
        List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lastWeekLottoNumberText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);

        return new Lotto(lastWeekLottoNumbers);
    }

    private LottoResult lottoResult(Lottos lottos, Lotto lastWeekLotto) {
        LottoResult lottoResult = new LottoResult(lottos, lastWeekLotto);
        resultView.printLottoResult(lottoResult);

        return lottoResult;
    }
}
