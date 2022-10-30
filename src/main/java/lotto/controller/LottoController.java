package lotto.controller;

import lotto.domain.*;
import lotto.view.InputConsole;
import lotto.view.OutputConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoController {

    public void run() {
        int lottoCount = LottoCalculator.availableToPurchaseCount(inputMoney());
        printLottoCount(lottoCount);

        Lottos lottos = autoPurchaseLotto(lottoCount);
        lottos.print();

        WinningLotto winningLotto = inputWinningLotto();
        printStatistics(winningLotto, lottos);
    }

    private Money inputMoney() {
        try {
            String input = InputConsole.inputMoneyForPurchaseLotto();
            Money money = new Money(input);
            LottoCalculator.availableToPurchaseCount(money);
            return money;
        } catch (IllegalArgumentException e) {
            OutputConsole.out(e.getMessage());
            return inputMoney();
        }
    }

    private Lottos autoPurchaseLotto(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(LottoNumbers.generate()));
        }
        return new Lottos(lottos);
    }

    private WinningLotto inputWinningLotto() {
        try {
            String input = InputConsole.inputWinningLottoNumbers();
            return new WinningLotto(new Lotto(input));
        } catch (IllegalArgumentException e) {
            OutputConsole.out(e.getMessage());
            return inputWinningLotto();
        }
    }

    private void printLottoCount(int lottoCount) {
        OutputConsole.purchaseResult(lottoCount);
    }

    private void printStatistics(WinningLotto winningLotto, Lottos lottos) {
        OutputConsole.statistics();
        printWinnigCount(winningLotto, lottos);
        printRateOfReturn(winningLotto, lottos);
    }

    private void printWinnigCount(WinningLotto winningLotto, Lottos lottos) {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        ranks.stream()
                .filter(rank -> rank != Rank.NO_MATCH)
                .forEach(rank -> {
                    int count = LottoCalculator.winningCount(winningLotto, lottos, rank);
                    OutputConsole.winningCount(rank, count);
                });
    }

    private void printRateOfReturn(WinningLotto winningLotto, Lottos lottos) {
        OutputConsole.rateOfReturn(LottoCalculator.rateOfReturn(winningLotto, lottos));
    }

}
