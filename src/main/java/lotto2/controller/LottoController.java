package lotto2.controller;

import lotto2.model.*;
import lotto2.view.LottoView;

import java.util.*;

public class LottoController {
    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        final MoneyToBuy money = acceptInputMoney();
        final List<List<LottoNumber>> lottoBucket = generateManyLotto(money);
        final WinningNumbers winningNumbers = acceptWinningNumbers();
        final LottoNumber bonusNumber = acceptBonusNumber();
        final Map<WinningRank, Integer> result = calculateLotto(lottoBucket, winningNumbers, bonusNumber);
        lottoView.printResultTitle();
        final List<WinningRankCountDto> winningRankCounts = winningRankCountsAsArray(result);
        displayStatistics(winningRankCounts);
        final double profitRatio = calculateProfitRatio(money, winningRankCounts);
        displayProfitRatio(profitRatio);
    }

    private MoneyToBuy acceptInputMoney() {
        lottoView.printDemandInputMoney();
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final MoneyToBuy money = new MoneyToBuy(input);
        lottoView.printNumberOfBoughtLotto(money.getCount());
        return money;
    }

    private List<List<LottoNumber>> generateManyLotto(MoneyToBuy money) {
        final List<List<LottoNumber>> lottoBucket = new ArrayList<>();
        final Round round = new Round(money.getCount());
        while (round.hasNext()) {
            round.goNext();
            lottoBucket.add(generateEachLotto());
        }
        lottoView.printListOfLotto(lottoBucket);
        return lottoBucket;
    }

    private List<LottoNumber> generateEachLotto() {
        final List<LottoNumber> lotto = LottoGenerator.generate();
        return lotto;
    }

    private WinningNumbers acceptWinningNumbers() {
        lottoView.printDemandWinningNumbers();
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final WinningNumbers winningNumbers = new WinningNumbers(input);
        return winningNumbers;
    }

    private LottoNumber acceptBonusNumber() {
        lottoView.printDemandBonusNumber();
        final Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();
        final LottoNumber bonusNumber = new LottoNumber(input);
        return bonusNumber;
    }

    private Map<WinningRank, Integer> calculateLotto(
            List<List<LottoNumber>> lottoBucket,
            WinningNumbers winningNumbers,
            LottoNumber bonusNumber) {
        final Map<WinningRank, Integer> countForEachWinningRank = new HashMap<>();
        countForEachWinningRank.put(WinningRank.FIFTH, 0);
        countForEachWinningRank.put(WinningRank.FOURTH, 0);
        countForEachWinningRank.put(WinningRank.THIRD, 0);
        countForEachWinningRank.put(WinningRank.SECOND, 0);
        countForEachWinningRank.put(WinningRank.FIRST, 0);
        final List<LottoNumber> lottoWinningNumbers = winningNumbers.getWinningNumbers();
        for (List<LottoNumber> eachLotto : lottoBucket) {
            int winningCount = 0;
            for (LottoNumber currentWinningNumber : lottoWinningNumbers) {
                if (eachLotto.contains(currentWinningNumber)) {
                    ++winningCount;
                }
            }
            if (winningCount < 3 || 6 < winningCount) {
                continue;
            }
            if (winningCount == 3) {
                final int count = countForEachWinningRank.get(WinningRank.FIFTH);
                countForEachWinningRank.put(WinningRank.FIFTH, count + 1);
                continue;
            }
            if (winningCount == 4) {
                if (eachLotto.contains(bonusNumber)) {
                    final int count = countForEachWinningRank.get(WinningRank.SECOND);
                    countForEachWinningRank.put(WinningRank.SECOND, count + 1);
                    continue;
                }
                final int count = countForEachWinningRank.get(WinningRank.FOURTH);
                countForEachWinningRank.put(WinningRank.FOURTH, count + 1);
                continue;
            }
            if (winningCount == 5) {
                final int count = countForEachWinningRank.get(WinningRank.THIRD);
                countForEachWinningRank.put(WinningRank.THIRD, count + 1);
                continue;
            }
            final int count = countForEachWinningRank.get(WinningRank.FIRST);
            countForEachWinningRank.put(WinningRank.FIRST, count + 1);
        }
        return countForEachWinningRank;
    }

    private List<WinningRankCountDto> winningRankCountsAsArray(Map<WinningRank, Integer> result) {
        final List<WinningRankCountDto> winningRankCounts = new ArrayList<>(result.size());
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FIFTH, result.get(WinningRank.FIFTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FOURTH, result.get(WinningRank.FOURTH)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.THIRD, result.get(WinningRank.THIRD)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.SECOND, result.get(WinningRank.SECOND)));
        winningRankCounts.add(new WinningRankCountDto(LottoPrizeEnum.FIRST, result.get(WinningRank.FIRST)));
        return winningRankCounts;
    }

    private void displayStatistics(List<WinningRankCountDto> winningRankCounts) {
        lottoView.printStatistics(winningRankCounts);
    }

    private double calculateProfitRatio(MoneyToBuy money, List<WinningRankCountDto> winningRankCounts) {
        int totalPrize = 0;
        for (final WinningRankCountDto winningRankCount : winningRankCounts) {
            totalPrize += winningRankCount.getLottoPrizeEnum().getPrize() * winningRankCount.getCount();
        }
        return (double) totalPrize / money.getValue();
    }

    private void displayProfitRatio(double profitRatio) {
        lottoView.printProfitRatio(profitRatio);
    }
}
