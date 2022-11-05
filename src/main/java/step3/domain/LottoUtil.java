package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoUtil {

    private static final int LOTTO_PRICE = 1000;

    public LottoUtil() {
    }

    public static int buy(Money money) {
        return money.getMoney() / LOTTO_PRICE;
    }

    public static Lottos buy(List<String> manualLottoNumbers) {
        return manualLottoNumbers.stream()
            .map(LottoGenerator::create)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    public static Money calculateTotalPrice(int purchaseCount) {
        return new Money(purchaseCount).multiply(purchaseCount);
    }
}
