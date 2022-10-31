package lotto;

import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Scanner;

public class LottoStore {

    public void entrance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구매 금액을 입력해 주세요.");
        LottoBag lottoList = LottoIssuer.issue(
                new Money(scanner.nextLine()), new LottoNumberGenerator());
        InputView.printNumbers(lottoList);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        WinningResultBag results = LottoIssuer.result(lottoList, new LottoNumberBag(scanner.nextLine()));
        ResultView.printResult(results);
    }
}
