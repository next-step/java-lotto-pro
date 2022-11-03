package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoIssuer {

    private LottoIssuer() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static LottoBag issue(int availableCount, NumberGenerator numberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < availableCount; i++) {
            lottoList.add(new Lotto(numberGenerator));
        }
        return new LottoBag(lottoList);
    }

    public static WinningResultBag result(LottoBag lottoBag, WinningLottoBallBag winningLottoBallBag) {
        return new WinningResultBag(lottoBag.getResult(winningLottoBallBag));
    }
}
