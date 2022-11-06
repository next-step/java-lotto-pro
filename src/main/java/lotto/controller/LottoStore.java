package lotto.controller;

import lotto.GenerateCount;
import lotto.LottoBag;
import lotto.LottoBall;
import lotto.LottoIssuer;
import lotto.LottoNumberBag;
import lotto.LottoNumberGenerator;
import lotto.Money;
import lotto.WinningLottoBallBag;
import lotto.WinningResultBag;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoStore {

    private final Scanner scanner = new Scanner(System.in);

    public void entrance() {
        InputView.inputMoney();
        GenerateCount availableCount = new GenerateCount(LottoBag.availableCount(new Money(scanner.nextLine())));

        InputView.inputManualCount();
        GenerateCount manualCount = new GenerateCount(scanner.nextLine());
        availableCount.validGreaterThan(manualCount);

        GenerateCount autoCount = availableCount.minus(manualCount);

        LottoBag lottoBag = issueLotto(autoCount, manualCount);
        InputView.printNumbers(lottoBag);

        result(lottoBag);
    }

    private LottoBag issueLotto(GenerateCount autoCount, GenerateCount manualCount) {
        List<LottoNumberBag> manualLottoNumbers = inputNumber(manualCount);

        InputView.printManualAutoCount(manualCount.getCount(), autoCount.getCount());

        return LottoBag.concat(LottoIssuer.issueManual(manualLottoNumbers),
                LottoIssuer.issueAuto(autoCount.getCount(), new LottoNumberGenerator()));
    }

    private List<LottoNumberBag> inputNumber(GenerateCount manualCount) {
        long count = manualCount.getCount();
        InputView.inputManualNumbers();
        List<LottoNumberBag> lottoNumberBags = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumberBags.add(LottoNumberBag.fromManualNumbers(scanner.nextLine()));
        }
        return lottoNumberBags;
    }

    private void result(LottoBag lottoBag) {
        InputView.inputLastWinningNumbers();
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag(scanner.nextLine());

        InputView.inputBonusNumber();
        winningLottoBallBag.add(LottoBall.fromStringBonus(scanner.nextLine()));

        WinningResultBag results = LottoIssuer.result(lottoBag, winningLottoBallBag);
        ResultView.printResult(results.groupByWinningResult());
        ResultView.printProfitRate(results.calculateProfitRate());
    }
}
