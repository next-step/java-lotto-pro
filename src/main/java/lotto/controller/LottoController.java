package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        LottoBundle lottoBundle = buyLotto(paidMoney);
        List<Integer> winningNumbers = getWinningNumbers();
        showResult(paidMoney, lottoBundle, winningNumbers);
    }

    private Money getPaidMoney() {
        this.view.showMessageRequestPurchaseMoney();
        return Money.of(Integer.parseInt(this.input.getInput()));
    }

    private LottoBundle buyLotto(Money paidMoney) {
        LottoBundle lottoBundle = this.lottoStore.buyLotto(paidMoney);
        this.view.showLottoCount(lottoBundle.size());
        this.view.showLotto(lottoBundle.printAll());
        return lottoBundle;
    }

    private List<Integer> getWinningNumbers() {
        this.view.showMessageRequestWinningNubmers();
        String input2 = this.input.getInput();
        return Arrays.stream(input2.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private void showResult(Money paidMoney, LottoBundle lottoBundle, List<Integer> winningNumbers) {
        WinningMoney winningMoney = lottoBundle.countWinning(winningNumbers);
        this.view.showMessageStatistics();
        for (WinningBonus bonus: WinningBonus.values()) {
            this.view.showStatistics(bonus,winningMoney.count(bonus));
        }
        this.view.showYield(winningMoney.calcYield(paidMoney));
    }
}
