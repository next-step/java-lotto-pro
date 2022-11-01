package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoBag.LOTTO_PRICE;

public class LottoIssuer {

    private LottoIssuer() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static LottoBag issue(Money money, NumberGenerator numberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        while (money.isEqualsOrGreater(LOTTO_PRICE)) {
            money = money.minus(LOTTO_PRICE);
            lottoList.add(new Lotto(numberGenerator));
        }
        return new LottoBag(lottoList);
    }

    public static WinningResultBag result(LottoBag lottoBag, WinningLottoBallBag winningLottoBallBag) {
        return new WinningResultBag(lottoBag.getResult(winningLottoBallBag));
    }
}
