package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final int LOTTO_PRICE = 1000;

    public static LottoGame sell(Money money) {
        int tryCount = money.calculateTryLottoCount(money, LOTTO_PRICE);
        List<LottoBalls> lottoBalls = createLottoBalls(tryCount);
        return new LottoGame(tryCount, lottoBalls);
    }

    private static List<LottoBalls> createLottoBalls(int tryCount) {
        return Stream.generate( () -> new LottoBalls(LottoBallFactory.draw()))
                .limit(tryCount)
                .collect(Collectors.toList());
    }
}
