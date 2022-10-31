package lotto;

import lotto.view.ResultView;

import java.util.List;

public class LottoIssuer {

    private LottoIssuer() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static LottoBag issue(Money money, NumberGenerator numberGenerator) {
        return new LottoBag(money, numberGenerator);
    }

    public static void result(LottoBag lottoBag, List<Integer> winningNumbers) {
        WinningResultBag results = new WinningResultBag(lottoBag.getResult(winningNumbers));
        ResultView.printResult(results);
    }
}
