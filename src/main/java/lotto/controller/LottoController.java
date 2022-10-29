package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LottoView view;
    private final LottoUserInput input;
    private final LottoStore lottoStore;

    public LottoController(LottoView view, LottoUserInput input, LottoStore lottoStore) {
        this.view = view;
        this.input = input;
        this.lottoStore = lottoStore;
    }

    public void start() {
        Money paidMoney = getPaidMoney();
        LottoBundle lottoBundle = lottoStore.buyLotto(paidMoney);
        showLottoBundle(lottoBundle);
        WinningMoney winningMoney = lottoBundle.countWinning(getWinningLotto());
        showResult(paidMoney, winningMoney);
    }

    private Lotto getWinningLotto() {
        return new Lotto(getWinningNumbers());
    }

    private void showLottoBundle(LottoBundle lottoBundle) {
        view.showLottoCount(lottoBundle.size());
        view.showLotto(lottoBundle.toString());
    }

    private Money getPaidMoney() {
        view.showMessageRequestPurchaseMoney();
        return Money.of((input.getPositiveInteger()));
    }

    private List<Integer> getWinningNumbers() {
        view.showMessageRequestWinningNumbers();
        return input.getWinningLottoNumbers();
    }

    private void showResult(Money paidMoney, WinningMoney winningMoney) {
        view.showMessageStatistics();
        for (WinningBonus bonus: WinningBonus.values()) {
            view.showStatistics(bonus,winningMoney.count(bonus));
        }
        view.showYield(winningMoney.calcYield(paidMoney));
    }
}
