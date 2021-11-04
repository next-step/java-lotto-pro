package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoTicket;
import lotto.domain.Winning;
import lotto.module.AutoGenerator;

import static lotto.view.ConsoleView.*;

public final class LottoController {

    private LottoController() {
    }

    public static LottoController getInstance() {
        return LazyHolder.INSTANCE;
    }

    public BoughtLotto buyLotto() {
        try {
            return new BoughtLotto(Integer.parseInt(enterMoney()));
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return buyLotto();
        }
    }

    public LottoTicket generateLottoTicket(BoughtLotto boughtLotto) {
        return LottoTicket.generate(boughtLotto.getBoughtCount(), AutoGenerator.getInstance());
    }

    public Winning enterWinningLottoNumbers() {
        try {
            return new Winning(enterWinning());
        } catch (IllegalArgumentException e) {
            printError(e.getMessage());
            return enterWinningLottoNumbers();
        }
    }

    private static class LazyHolder {
        public static final LottoController INSTANCE = new LottoController();
    }
}
