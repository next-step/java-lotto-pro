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

public class LottoController {
    private final static String LOTTO_NUMBER_TEXT_SPLIT_VALUE = ", ";

    public void play() {
        InputView.printInputPurchasePrice();
        String purchasePriceText = InputView.inputPurchasePrice();
        int purchaseCount = purchaseLotto(purchasePriceText);

        Lottos lottos = issueLottos(new LottoAutoIssuedServiceImpl(), purchaseCount);
        Lotto answerLotto = answerLotto();
        LottoNumber lottoNumber = bonusLottoNumber();

        lottoResult(lottos, answerLotto, lottoNumber);
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

    private Lotto answerLotto() {
        InputView.printInputLastWeekWinningNumber();
        String lastWeekLottoNumberText = InputView.inputLastWeekWinningNumber();
        List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lastWeekLottoNumberText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);

        return  new Lotto(new HashSet<>(lastWeekLottoNumbers));
    }

    public LottoNumber bonusLottoNumber() {
        InputView.printInputBonusBall();
        String lastWeekLottoBonusBallText = InputView.inputLastWeekBonusNumber();

        return new LottoNumber(NumberUtil.parseStringToInt(lastWeekLottoBonusBallText));
    }

    private LottoResult lottoResult(Lottos lottos, Lotto answerLotto, LottoNumber bonusLottoNumber) {
        LottoResult lottoResult = new LottoResult(lottos.lottoWinningResult(answerLotto, bonusLottoNumber));
        ResultView.printLottoResult(lottoResult);

        return lottoResult;
    }
}
