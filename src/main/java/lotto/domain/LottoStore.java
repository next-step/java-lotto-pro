package lotto.domain;

import lotto.exception.CreateLottoStoreException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStore {
    private static final int LOTTO_PRICE = 1_000;

    private LottoStore() {
        throw new CreateLottoStoreException("LottoStore 생성자는 호출되면 안됩니다.");
    }

    public static LottoGame sell(List<String> manualNumbersStrings, Money money) {
        List<LottoBalls> manualLottoBalls = createManualLottoBalls(manualNumbersStrings);
        int allTryCount = money.calculateTryLottoCount(LOTTO_PRICE);
        TryCount tryCount = new TryCount(allTryCount, manualLottoBalls.size());
        List<LottoBalls> autoLottoBalls = Collections.unmodifiableList(createLottoBalls(tryCount.getAutoTryCount()));
        return createLottoGame(manualLottoBalls, autoLottoBalls, tryCount);
    }

    private static List<LottoBalls> createManualLottoBalls(List<String> manualNumbersStrings) {
        return Collections.unmodifiableList(
                manualNumbersStrings.stream()
                        .map(numbersString -> new LottoBalls(LottoBallFactory.createLottoBallByStringNumber(numbersString)))
                        .collect(Collectors.toList())
        );
    }

    private static List<LottoBalls> createLottoBalls(int tryCount) {
        return Stream.generate(() -> new LottoBalls(LottoBallFactory.draw()))
                .limit(tryCount)
                .collect(Collectors.toList());
    }

    private static LottoGame createLottoGame(List<LottoBalls> manualLottoBalls, List<LottoBalls> autoLottoBalls, TryCount tryCount) {
        return new LottoGame(
                tryCount,
                Stream.concat(manualLottoBalls.stream(), autoLottoBalls.stream()).collect(Collectors.toList())
        );
    }
}
