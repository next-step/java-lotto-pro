package lotto.controller;

import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.LottoView;

public class LottoController {

    private final LottoGame lottoGame;
    private final LottoView view;

    public LottoController(LottoGame lottoGame, LottoView view) {
        this.lottoGame = lottoGame;
        this.view = view;
    }

    public void createLottoNumbers() {
        Runnable readPurchase = () -> {
            lottoGame.createPurchase(view.readPurchase());
            lottoGame.createLottoNumbers();
            view.printLottoNumbers(lottoGame.getLottoNumbers());
        };
        while (isNotComplete(readPurchase)) {
        }
    }

    public void createNumberAndMatcher(List<Runnable> bonusStrategy) {
        bonusStrategy.forEach(runnable -> {
            while (isNotComplete(runnable)) {
            }
        });
    }

    public void startLottoGame() {
        view.printResult(lottoGame.result());
        view.printProfitMargin(lottoGame.makeProfitMargin());
    }

    private boolean isNotComplete(Runnable runnable) {
        try {
            runnable.run();
            return false;
        } catch (IllegalArgumentException ex) {
            view.printErrorMessage(ex.getMessage());
        }
        return true;
    }
}
