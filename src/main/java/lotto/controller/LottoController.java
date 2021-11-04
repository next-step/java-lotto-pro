package lotto.controller;

import lotto.domain.BoughtLotto;
import lotto.domain.LottoTicket;
import lotto.module.AutoGenerator;

import static lotto.view.ConsoleView.enterMoney;

public final class LottoController {

    private LottoController() {
    }

    public static LottoController getInstance() {
        return LazyHolder.INSTANCE;
    }

    public BoughtLotto buyLotto() {
        return new BoughtLotto(enterMoney());
    }

    public LottoTicket generateLottoTicket(BoughtLotto boughtLotto) {
        return LottoTicket.generate(boughtLotto.getBoughtCount(), AutoGenerator.getInstance());
    }

    private static class LazyHolder {
        public static final LottoController INSTANCE = new LottoController();
    }
}
