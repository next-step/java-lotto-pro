package lotto.controller;

import lotto.domain.LottoGame;
import lotto.view.LottoView;

public abstract class LottoController {

    final LottoGame lottoGame;
    final LottoView view;
    final Runnable bonusStrategy;

    public LottoController(LottoGame lottoGame, LottoView view, Runnable bonusStrategy) {
        this.lottoGame = lottoGame;
        this.view = view;
        this.bonusStrategy = bonusStrategy;
    }

    public void start() {
        createLottoNumbers();
        createWinningNumberAndMatcher();
        startLottoGame();
    }

    void createLottoNumbers() {
        Runnable readPurchase = () -> {
            lottoGame.createPurchase(view.readPurchase());
            lottoGame.createLottoNumbers();
            view.printLottoNumbers(lottoGame.makeLottoNumbersResult());
        };
        while (isNotComplete(readPurchase)) {
        }
    }

    boolean isNotComplete(Runnable runnable) {
        try {
            runnable.run();
            return false;
        } catch (IllegalArgumentException ex) {
            view.printErrorMessage(ex.getMessage());
        }
        return true;
    }

    private void createWinningNumberAndMatcher() {
        lottoGame.createWinningNumber(view.readWinningNumber());
        while (isNotComplete(bonusStrategy)) {
        }
    }

    private void startLottoGame() {
        view.printResult(lottoGame.result());
        view.printProfitMargin(lottoGame.makeProfitMargin());
    }
}
