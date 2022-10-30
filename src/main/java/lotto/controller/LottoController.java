package lotto.controller;

import lotto.domain.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoService service;
    private final LottoView view;

    public LottoController(LottoService service, LottoView view) {
        this.service = service;
        this.view = view;
    }

    public void createLottoNumbers() {
        Runnable readPurchase = () -> {
            service.savePurchase(view.readPurchase());
            service.saveLottoNumbers();
            view.printLottoNumbers(service.findLottoNumbers());
        };
        while (isNotComplete(readPurchase)) {
        }
    }

    public void createLotto() {
        Runnable readWinningNumber = () -> service.saveLottoGame(view.readWinningNumber());
        while (isNotComplete(readWinningNumber)) {
        }
    }

    public void startLotto() {
        view.printResult(service.result());
        view.printProfitMargin(service.makeProfitMargin());
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
