package lotto.controller;

import lotto.domain.*;
import lotto.domain.LottoMachine;
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

        Lottos lottos = issueLottos(purchaseCount);
        Lotto answerLotto = answerLotto();
        LottoNumber bonusLottoNumber = bonusLottoNumber();

        LottoWinning lottoWinning = new LottoWinning(answerLotto, bonusLottoNumber);
        lottoResult(lottos, lottoWinning);
    }

    private int purchaseLotto(String purchasePriceText) {
        LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
        int purchaseCount = lottoPurchase.purchaseCount();
        ResultView.printPurchaseLottoCount(purchaseCount);

        return purchaseCount;
    }

    private Lottos issueLottos(int purchaseCount) {
        Lottos lottos = LottoMachine.issueAutoLottos(purchaseCount);
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

    private LottoResult lottoResult(Lottos lottos, LottoWinning lottoWinning) {
        LottoResult lottoResult = new LottoResult(lottos.lottoWinningResult(lottoWinning));
        ResultView.printLottoResult(lottoResult);

        return lottoResult;
    }
}
