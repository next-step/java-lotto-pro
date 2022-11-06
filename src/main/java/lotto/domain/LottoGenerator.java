package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.Number.MAXIMUM_NUMBER;
import static lotto.domain.Number.MINIMUM_NUMBER;

public class LottoGenerator {
    public static final String PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE = "1개 이상부터 구매가능합니다.";
    public static final int ZERO = 0;
    public static final String NULL_EXCEPTION_MESSAGE = "null 일 수 없습니다.";
    private final List<Integer> range = new ArrayList<>();

    public LottoGenerator() {
        init();
    }

    private void init() {
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            this.range.add(i);
        }
    }

    public Lottos generate(int purchaseCount) {
        validatePurchaseCount(purchaseCount);
        return createLottos(purchaseCount);
    }

    private static void validatePurchaseCount(int purchaseCount) {
        if (purchaseCount <= ZERO) {
            throw new IllegalArgumentException(PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private Lottos createLottos(int purchaseCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private Lotto createLotto() {
        Collections.shuffle(this.range);
        return new Lotto(this.range.subList(ZERO, LOTTO_SIZE));
    }
}
