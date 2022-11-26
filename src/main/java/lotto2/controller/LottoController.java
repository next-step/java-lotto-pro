package lotto2.controller;

import lotto2.model.*;
import lotto2.model.enums.LottoPrize;
import lotto2.model.enums.WinningRank;
import lotto2.model.generator.LottoGeneratorFromUserInput;
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
        final MoneyToBuy moneyToBuy = acceptInputMoney();
        final ManualLottoCount manualLottoCount = acceptManualCount(moneyToBuy);
        final List<Lotto> lottoBucket = acceptManyManualLotto(manualLottoCount);
        final int automaticLottoCount = getAutomaticLottoCount(moneyToBuy, manualLottoCount);
        generateManyAutomaticLotto(automaticLottoCount, lottoBucket);
        displayAllLotto(manualLottoCount, automaticLottoCount, lottoBucket);
        final WinningLotto winningLotto = acceptWinningNumbers();
        acceptBonusNumber(winningLotto);
        final Map<WinningRank, Integer> result = calculateLotto(lottoBucket, winningLotto);
        final List<WinningRankCountDto> winningRankCounts = winningRankCountsAsArray(result);
        displayStatistics(winningRankCounts);
        final double profitRatio = calculateProfitRatio(moneyToBuy, winningRankCounts);
        displayProfitRatio(profitRatio);
    }

    private MoneyToBuy acceptInputMoney() {
        return inputView.inputMoney();
    }

    private ManualLottoCount acceptManualCount(MoneyToBuy moneyToBuy) {
        return inputView.inputManualCount(moneyToBuy);
    }

    private List<Lotto> acceptManyManualLotto(ManualLottoCount lottoCount) {
        return inputView.inputManyManualLotto(lottoCount);
    }

    private int getAutomaticLottoCount(MoneyToBuy moneyToBuy, ManualLottoCount manualLottoCount) {
        return moneyToBuy.count() - manualLottoCount.count();
    }

    private List<Lotto> generateManyAutomaticLotto(int count, List<Lotto> lottoBucket) {
        final Round round = new Round(count);
        while (round.hasNext()) {
            round.goNext();
            lottoBucket.add(generateEachLotto());
        }
        return lottoBucket;
    }

    private Lotto generateEachLotto() {
        return LottoGeneratorRandom.generate();
    }

    private void displayAllLotto(ManualLottoCount manualLottoCount, int automaticLottoCount, List<Lotto> lottoBucket) {
        outputView.printListOfLotto(manualLottoCount, automaticLottoCount, lottoBucket);
    }

    private WinningLotto acceptWinningNumbers() {
        final String input = inputView.inputWinningNumbers();
        final LottoGeneratorFromUserInput lottoGenerator = new LottoGeneratorFromUserInput(input);
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

    private double calculateProfitRatio(MoneyToBuy moneyToBuy, List<WinningRankCountDto> winningRankCounts) {
        int totalPrize = 0;
        for (final WinningRankCountDto winningRankCount : winningRankCounts) {
            totalPrize += winningRankCount.getLottoPrize().getPrize() * winningRankCount.getCount();
        }
        return (double) totalPrize / moneyToBuy.value();
    }

    private void displayProfitRatio(double profitRatio) {
        outputView.printProfitRatio(profitRatio);
    }
}
