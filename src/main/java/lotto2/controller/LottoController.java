package lotto2.controller;

import lotto2.model.*;
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
        final Lotto winningNumbers = acceptWinningNumbers();
        final LottoNumber bonusNumber = acceptBonusNumber();
        final Map<WinningRankEnum, Integer> result = calculateLotto(lottoBucket, winningNumbers, bonusNumber);
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

    private Lotto acceptWinningNumbers() {
        final String input = inputView.inputWinningNumbers();
        final LottoGeneratorFromWinningNumbers lottoGenerator = new LottoGeneratorFromWinningNumbers(input);
        return lottoGenerator.generate();
    }

    private LottoNumber acceptBonusNumber() {
        return inputView.inputBonusNumber();
    }

    private Map<WinningRankEnum, Integer> calculateLotto(
            List<Lotto> lottoBucket,
            Lotto winningNumbers,
            LottoNumber bonusNumber) {
        final Map<WinningRankEnum, Integer> countForEachWinningRank = initializeCountMap();
        for (Lotto eachLotto : lottoBucket) {
            int matchCount = getMatchCount(eachLotto, winningNumbers);
            if (matchCount < 3 || 6 < matchCount) {
                continue;
            }
            if (matchCount == 3) {
                final int count = countForEachWinningRank.get(WinningRankEnum.FIFTH);
                countForEachWinningRank.put(WinningRankEnum.FIFTH, count + 1);
                continue;
            }
            if (matchCount == 4) {
                if (eachLotto.contains(bonusNumber)) {
                    final int count = countForEachWinningRank.get(WinningRankEnum.SECOND);
                    countForEachWinningRank.put(WinningRankEnum.SECOND, count + 1);
                    continue;
                }
                final int count = countForEachWinningRank.get(WinningRankEnum.FOURTH);
                countForEachWinningRank.put(WinningRankEnum.FOURTH, count + 1);
                continue;
            }
            if (matchCount == 5) {
                final int count = countForEachWinningRank.get(WinningRankEnum.THIRD);
                countForEachWinningRank.put(WinningRankEnum.THIRD, count + 1);
                continue;
            }
            final int count = countForEachWinningRank.get(WinningRankEnum.FIRST);
            countForEachWinningRank.put(WinningRankEnum.FIRST, count + 1);
        }
        return countForEachWinningRank;
    }

    private Map<WinningRankEnum, Integer> initializeCountMap() {
        final Map<WinningRankEnum, Integer> countForEachWinningRank = new HashMap<>();
        countForEachWinningRank.put(WinningRankEnum.FIFTH, 0);
        countForEachWinningRank.put(WinningRankEnum.FOURTH, 0);
        countForEachWinningRank.put(WinningRankEnum.THIRD, 0);
        countForEachWinningRank.put(WinningRankEnum.SECOND, 0);
        countForEachWinningRank.put(WinningRankEnum.FIRST, 0);
        return countForEachWinningRank;
    }

    private int getMatchCount(Lotto eachLotto, Lotto winningNumbers) {
        final List<LottoNumber> lottoWinningNumbers = winningNumbers.lottoNumbers();
        int matchCount = 0;
        for (LottoNumber currentWinningNumber : lottoWinningNumbers) {
            if (eachLotto.contains(currentWinningNumber)) {
                ++matchCount;
            }
        }
        return matchCount;
    }

    private List<WinningRankCountDto> winningRankCountsAsArray(Map<WinningRankEnum, Integer> result) {
        final List<WinningRankCountDto> winningRankCounts = new ArrayList<>(result.size());
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FIFTH, result.get(WinningRankEnum.FIFTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FOURTH, result.get(WinningRankEnum.FOURTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.THIRD, result.get(WinningRankEnum.THIRD)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.SECOND, result.get(WinningRankEnum.SECOND)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FIRST, result.get(WinningRankEnum.FIRST)));
        return winningRankCounts;
    }

    private void displayStatistics(List<WinningRankCountDto> winningRankCounts) {
        outputView.printStatistics(winningRankCounts);
    }

    private double calculateProfitRatio(MoneyToBuy money, List<WinningRankCountDto> winningRankCounts) {
        int totalPrize = 0;
        for (final WinningRankCountDto winningRankCount : winningRankCounts) {
            totalPrize += winningRankCount.getLottoPrizeEnum().getPrize() * winningRankCount.getCount();
        }
        return (double) totalPrize / money.getValue();
    }

    private void displayProfitRatio(double profitRatio) {
        outputView.printProfitRatio(profitRatio);
    }
}
