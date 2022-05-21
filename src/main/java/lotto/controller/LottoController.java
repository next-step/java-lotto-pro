package lotto.controller;

import lotto.domain.*;
import lotto.service.LottoAutoIssuedServiceImpl;
import lotto.service.LottoIssuedService;
import lotto.utils.ListUtil;
import lotto.utils.NumberUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoController {
    private final static String LOTTO_NUMBER_TEXT_SPLIT_VALUE = ", ";

    public void play() {
        InputView.printInputPurchasePrice();
        String purchasePriceText = InputView.inputPurchasePrice();
        int purchaseCount = purchaseLotto(purchasePriceText);

        Lottos lottos = issueLottos(new LottoAutoIssuedServiceImpl(), purchaseCount);
        Lotto lastWeekLotto = lastWeekLotto();

        lottoResult(lottos, lastWeekLotto);
    }

    private int purchaseLotto(String purchasePriceText) {
        LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
        int purchaseCount = lottoPurchase.purchaseCount();
        ResultView.printPurchaseLottoCount(purchaseCount);

        return purchaseCount;
    }

    private Lottos issueLottos(LottoIssuedService lottoIssuedService, int purchaseCount) {
        Lottos lottos = new Lottos(lottoIssuedService, purchaseCount);
        ResultView.printIssuedLottoNumber(lottos);

        return lottos;
    }

    private Lotto lastWeekLotto() {
        InputView.printInputLastWeekWinningNumber();
        String lastWeekLottoNumberText = InputView.inputLastWeekWinningNumber();
        List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lastWeekLottoNumberText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);

        Lotto answerLotto = new Lotto(new HashSet<>(lastWeekLottoNumbers));

        InputView.printInputBonusBall();
        String lastWeekLottoBonusBallText = InputView.inputLastWeekBonusNumber();

        answerLotto.addBonusBallNumber(NumberUtil.parseStringToInt(lastWeekLottoBonusBallText));

        return answerLotto;
    }

    private LottoResult lottoResult(Lottos lottos, Lotto lastWeekLotto) {
        LottoResult lottoResult = new LottoResult(lottos.lottoWinningResult(lastWeekLotto));
        ResultView.printLottoResult(lottoResult);

        return lottoResult;
    }
}
