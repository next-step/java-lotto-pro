package lotto.controller;

import lotto.domain.*;
import lotto.utils.ListUtil;
import lotto.utils.NumberUtil;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Supplier;

public class LottoController {
    private final static String LOTTO_NUMBER_TEXT_SPLIT_VALUE = ", ";

    public void play() {
        int purchaseCount = purchaseLotto();

        Lottos lottos = issueLottos(purchaseCount);
        Lotto answerLotto = answerLotto();
        LottoNumber bonusLottoNumber = bonusLottoNumber();

        LottoWinning lottoWinning = new LottoWinning(answerLotto, bonusLottoNumber);
        showLottoResult(lottos, lottoWinning);
    }

    private int purchaseLotto() {
        return retryThrowInput(() -> {
            InputView.printInputPurchasePrice();
            String purchasePriceText = InputView.inputPurchasePrice();

            LottoPurchase lottoPurchase = new LottoPurchase(purchasePriceText);
            int purchaseCount = lottoPurchase.purchaseCount();
            ResultView.printPurchaseLottoCount(purchaseCount);

            return purchaseCount;
        });
    }

    private Lottos issueLottos(int purchaseCount) {
        List<Lotto> manualIssueLottos = issueManualLottos();
        ResultView.printLottoPurchaseComplete(manualIssueLottos.size(), purchaseCount - manualIssueLottos.size());

        Lottos lottos = LottoMachine.issueLottos(manualIssueLottos, purchaseCount);
        ResultView.printIssuedLottoNumber(lottos);

        return lottos;
    }

    private List<Lotto> issueManualLottos() {
        int manualIssueCount = inputManualIssueCount();

        return retryThrowInput(() -> {
            InputView.printInputManualNumberCount();
            List<Lotto> manualIssueLottos = new ArrayList<>();
            for (int i = 0; i < manualIssueCount; i++) {
                String lottoNumbersText = InputView.inputLottoNumber();

                List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lottoNumbersText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);
                manualIssueLottos.add(new Lotto(new HashSet<>(lastWeekLottoNumbers)));
            }

            return manualIssueLottos;
        });

    }

    private int inputManualIssueCount() {
        return retryThrowInput(() -> {
            InputView.printInputManualIssueCount();

            return NumberUtil.parseStringToInt(InputView.inputNumber());
        });
    }

    private Lotto answerLotto() {
        InputView.printinputLottoNumber();
        String lastWeekLottoNumberText = InputView.inputLottoNumber();
        List<Integer> lastWeekLottoNumbers = ListUtil.stringToArrayInteger(lastWeekLottoNumberText, LOTTO_NUMBER_TEXT_SPLIT_VALUE);

        return  new Lotto(new HashSet<>(lastWeekLottoNumbers));
    }

    public LottoNumber bonusLottoNumber() {
        InputView.printInputBonusBall();
        String lastWeekLottoBonusBallText = InputView.inputNumber();

        return new LottoNumber(NumberUtil.parseStringToInt(lastWeekLottoBonusBallText));
    }

    private LottoResult showLottoResult(Lottos lottos, LottoWinning lottoWinning) {
        LottoResult lottoResult = new LottoResult(lottos.lottoWinningResult(lottoWinning));
        ResultView.printLottoResult(lottoResult);

        return lottoResult;
    }

    private <T> T retryThrowInput(Supplier<T> supplier) {
        T t = null;
        do {
            try {
                t = supplier.get();
            } catch (IllegalArgumentException illegalArgumentException) {
                ResultView.printMessage(illegalArgumentException.getMessage());
            }
        } while (t == null);

        return t;
    }
}
