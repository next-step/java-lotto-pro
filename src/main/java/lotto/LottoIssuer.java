package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoIssuer {

    private LottoIssuer() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static LottoBag issueAuto(long availableCount, NumberGenerator numberGenerator) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < availableCount; i++) {
            lottoList.add(new Lotto(numberGenerator));
        }
        return new LottoBag(lottoList);
    }

    public static LottoBag issueManuals(List<LottoNumberManualGenerator> lottoNumberManualGenerators) {
        return new LottoBag(lottoNumberManualGenerators.stream().map(Lotto::new)
                .collect(Collectors.toList()));
    }

    public static WinningResultBag result(LottoBag lottoBag, WinningLottoBallBag winningLottoBallBag) {
        return new WinningResultBag(lottoBag.getResult(winningLottoBallBag));
    }
}
