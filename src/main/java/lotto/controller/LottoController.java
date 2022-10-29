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
        boolean isComplete = false;
        while (!isComplete) {
            isComplete = readPurchase();
        }
    }

    public void createLotto() {
        boolean isComplete = false;
        while (!isComplete) {
            isComplete = readWinningNumber();
        }
    }

    public void startLotto() {
        view.printResult(service.result());
        view.printProfitMargin(service.makeProfitMargin());
    }

    private boolean readPurchase() {
        try {
            service.savePurchase(view.readPurchase());
            service.saveLottoNumbers();
            view.printLottoNumbers(service.findLottoNumbers());
            return true;
        } catch (IllegalArgumentException ex) {
            view.printErrorMessage(ex.getMessage());
        }
        return false;
    }

    private boolean readWinningNumber() {
        try {
            String readWinningNumber = view.readWinningNumber();
            service.saveLotto(readWinningNumber);
            return true;
        } catch (IllegalArgumentException ex) {
            view.printErrorMessage(ex.getMessage());
        }
        return false;
    }
}
