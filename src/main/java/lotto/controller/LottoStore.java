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
        System.out.println("구매 금액을 입력해 주세요.");
        GenerateCount availableCount = new GenerateCount(LottoBag.availableCount(new Money(scanner.nextLine())));

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
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
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoNumberBag> lottoNumberBags = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoNumberBags.add(LottoNumberBag.fromManualNumbers(scanner.nextLine()));
        }
        return lottoNumberBags;
    }

    private void result(LottoBag lottoBag) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag(scanner.nextLine());

        System.out.println("보너스 볼을 입력해 주세요.");
        winningLottoBallBag.add(LottoBall.fromStringBonus(scanner.nextLine()));

        WinningResultBag results = LottoIssuer.result(lottoBag, winningLottoBallBag);
        ResultView.printResult(results.groupByWinningResult());
        ResultView.printProfitRate(results.calculateProfitRate());
    }
}
