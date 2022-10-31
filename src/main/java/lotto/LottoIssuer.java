package lotto;

import java.util.List;

public class LottoIssuer {

    private LottoIssuer() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static LottoBag issue(Money money, NumberGenerator numberGenerator) {
        return new LottoBag(money, numberGenerator);
    }

    public static WinningResultBag result(LottoBag lottoBag, List<Integer> winningNumbers) {
        return new WinningResultBag(lottoBag.getResult(winningNumbers));
    }
}
