package lotto.controller;

import lotto.domain.BoughtLotto;

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

    private static class LazyHolder {
        public static final LottoController INSTANCE = new LottoController();
    }
}
