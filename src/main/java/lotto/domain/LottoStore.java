package lotto.domain;

import lotto.exception.CreateLottoStoreException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;

    private LottoStore() {
        throw new CreateLottoStoreException("LottoStore 생성자는 호출되면 안됩니다.");
    }

    public static LottoGame sell(Money money) {
        int tryCount = money.calculateTryLottoCount(money, LOTTO_PRICE);
        List<LottoBalls> lottoBalls = Collections.unmodifiableList(createLottoBalls(tryCount));
        return new LottoGame(tryCount, lottoBalls);
    }

    private static List<LottoBalls> createLottoBalls(int tryCount) {
        return Stream.generate(() -> new LottoBalls(LottoBallFactory.draw()))
                .limit(tryCount)
                .collect(Collectors.toList());
    }
}
