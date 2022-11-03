package lotto.controller;

import lotto.BonusScore;
import lotto.LottoBag;
import lotto.LottoBall;
import lotto.LottoIssuer;
import lotto.LottoNumberGenerator;
import lotto.Money;
import lotto.WinScore;
import lotto.WinningLottoBallBag;
import lotto.WinningResultBag;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoStore {

    public void entrance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매 금액을 입력해 주세요.");
        int availableCount = LottoBag.availableCount(new Money(scanner.nextLine()));
        LottoBag lottoList = LottoIssuer.issue(availableCount, new LottoNumberGenerator());
        InputView.printNumbers(lottoList);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        WinningLottoBallBag winningLottoBallBag = new WinningLottoBallBag(scanner.nextLine(), new WinScore());
        System.out.println("보너스 볼을 입력해 주세요.");
        winningLottoBallBag.add(new LottoBall(scanner.nextLine(), new BonusScore()));

        WinningResultBag results = LottoIssuer.result(lottoList, winningLottoBallBag);
        ResultView.printResult(results.groupByWinningResult());
        ResultView.printProfitRate(results.calculateProfitRate());
    }
}
