package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {
    private static final LottoController INSTANCE = new LottoController();
    private static final int YIELD_SCALE = 2;

    private final LottoMachine lottoMachine;

    private LottoController() {
        lottoMachine = LottoMachine.getInstance();
    }

    public void start() {
        long money = InputView.inputMoney();
        List<Lotto> lottoes = buyLotto(money);
        ResultView.printLottoNumber(lottoes);

        Lotto winner = new Lotto(InputView.inputAnswer());
        LottoNumber bonusNumber = LottoNumber.ofString(InputView.inputBonusAnswer());
        long totalPrize = exchangePrize(lottoes, new WinningNumbers(winner, bonusNumber));

        printYield(totalPrize, money);
    }

    public static LottoController getInstance() {
        return INSTANCE;
    }

    public List<Lotto> buyLotto(final long money) {
        int buyCount = lottoMachine.purchase(money);
        printBuyCount(buyCount);

        return lottoMachine.generateAutos(buyCount);
    }

    private void printBuyCount(final int buyCount) {
        ResultView.resultBuyCount(buyCount);
    }

    public long exchangePrize(final List<Lotto> lottoes, final WinningNumbers winningNumbers) {
        final Winners winners = getWinners(lottoes, winningNumbers);
        final Map<Prize, Long> rankCount = winners.getRankCount();
        ResultView.printEachPrize(rankCount);

        return winners.totalPrize(rankCount);
    }

    private Winners getWinners(final List<Lotto> lottoes, final WinningNumbers winningNumbers) {
        return new Winners(lottoes.stream()
                .map(lotto -> Prize.matchLotto(lotto, winningNumbers))
                .collect(Collectors.toList()));
    }

    public void printYield(final long totalPrize, final long money) {
        final float yield = getYield(totalPrize, money);
        ResultView.resultYield(yield);
    }

    private float getYield(final long totalPrize,final  long money) {
        return new BigDecimal(totalPrize)
                .divide(new BigDecimal(money), YIELD_SCALE, RoundingMode.CEILING)
                .floatValue();
    }
}
