package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final Scanner scanner;

    public LottoController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        final int buyMoney = getBuyMoney();
        final Lottos lottos = generateLottos(buyMoney);
        final LottoNumbers winNumbers = getWinNumbers();
        printResult(lottos, winNumbers);
    }

    private int getBuyMoney() {
        inputView.showEnterBuyMoneyMessage();
        final int buyMoney = scanner.nextInt();
        scanner.nextLine();
        return buyMoney;
    }

    private Lottos generateLottos(int buyMoney) {
        final int lottoCount = Lotto.howManyLottosCanIBuyWith(new Money(buyMoney));
        final Lottos lottos = Lottos.generateAuto(lottoCount);
        inputView.showLottoBoughtMessage(lottos);
        return lottos;
    }

    private LottoNumbers getWinNumbers() {
        inputView.showEnterWinNumbersMessage();
        final String input = scanner.nextLine();
        final String[] inputs = input.split(",");
        final List<Integer> inputNumbers = Arrays.stream(inputs)
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return LottoNumbers.of(inputNumbers);
    }

    private void printResult(Lottos lottos, LottoNumbers winNumbers) {
        final Winnings winnings = lottos.calculateWinning(winNumbers);
        final double roi = winnings.getReturnOnInvestment(lottos.getSellingPrice());
        resultView.showWinningStatistics(winnings);
        resultView.showReturnOnInvestment(roi);
    }
}
