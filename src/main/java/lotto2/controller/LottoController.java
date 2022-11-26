package lotto2.controller;

import lotto2.model.*;
import lotto2.model.enums.LottoPrize;
import lotto2.model.enums.WinningRank;
import lotto2.model.generator.LottoGeneratorFromWinningNumbers;
import lotto2.model.generator.LottoGeneratorRandom;
import lotto2.view.InputView;
import lotto2.view.OutputView;

import java.util.*;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final MoneyToBuy money = acceptInputMoney();
        final List<Lotto> lottoBucket = generateManyLotto(money);
        final WinningLotto winningLotto = acceptWinningNumbers();
        acceptBonusNumber(winningLotto);
        final Map<WinningRank, Integer> result = calculateLotto(lottoBucket, winningLotto);
        final List<WinningRankCountDto> winningRankCounts = winningRankCountsAsArray(result);
        displayStatistics(winningRankCounts);
        final double profitRatio = calculateProfitRatio(money, winningRankCounts);
        displayProfitRatio(profitRatio);
    }

    private MoneyToBuy acceptInputMoney() {
        final MoneyToBuy money = inputView.inputMoney();
        outputView.printNumberOfBoughtLotto(money);
        return money;
    }

    private List<Lotto> generateManyLotto(MoneyToBuy money) {
        final List<Lotto> lottoBucket = new ArrayList<>();
        final Round round = new Round(money.getCount());
        while (round.hasNext()) {
            round.goNext();
            lottoBucket.add(generateEachLotto());
        }
        outputView.printListOfLotto(lottoBucket);
        return lottoBucket;
    }

    private Lotto generateEachLotto() {
        return LottoGeneratorRandom.generate();
    }

    private WinningLotto acceptWinningNumbers() {
        final String input = inputView.inputWinningNumbers();
        final LottoGeneratorFromWinningNumbers lottoGenerator = new LottoGeneratorFromWinningNumbers(input);
        return new WinningLotto(lottoGenerator.generate());
    }

    private WinningLotto acceptBonusNumber(WinningLotto winningLotto) {
        final LottoNumber bonusNumber = inputView.inputBonusNumber();
        winningLotto.setBonusNumber(bonusNumber);
        return winningLotto;
    }

    private Map<WinningRank, Integer> calculateLotto(List<Lotto> lottoBucket, WinningLotto winningLotto) {
        final LottoCalculationUtils lottoCalculationUtils = new LottoCalculationUtils();
        Map<WinningRank, Integer> countForEachWinningRank = lottoCalculationUtils.initializeCountMap();
        for (Lotto eachLotto : lottoBucket) {
            final int matchCount = eachLotto.getMatchCount(winningLotto.getLotto());
            final WinningRank winningRank = lottoCalculationUtils.winningRankForMatchCount(matchCount,
                    eachLotto.contains(winningLotto.getBonusNumber()));
            countForEachWinningRank = lottoCalculationUtils.setCountForEachWinningRank(
                    countForEachWinningRank, winningRank);
        }
        return countForEachWinningRank;
    }

    private List<WinningRankCountDto> winningRankCountsAsArray(Map<WinningRank, Integer> result) {
        final List<WinningRankCountDto> winningRankCounts = new ArrayList<>(result.size());
        winningRankCounts.add(new WinningRankCountDto(LottoPrize.FIFTH, result.get(WinningRank.FIFTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrize.FOURTH, result.get(WinningRank.FOURTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrize.THIRD, result.get(WinningRank.THIRD)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrize.SECOND, result.get(WinningRank.SECOND)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrize.FIRST, result.get(WinningRank.FIRST)));
        return winningRankCounts;
    }

    private void displayStatistics(List<WinningRankCountDto> winningRankCounts) {
        outputView.printStatistics(winningRankCounts);
    }

    private double calculateProfitRatio(MoneyToBuy money, List<WinningRankCountDto> winningRankCounts) {
        int totalPrize = 0;
        for (final WinningRankCountDto winningRankCount : winningRankCounts) {
            totalPrize += winningRankCount.getLottoPrize().getPrize() * winningRankCount.getCount();
        }
        return (double) totalPrize / money.getValue();
    }

    private void displayProfitRatio(double profitRatio) {
        outputView.printProfitRatio(profitRatio);
    }
}
