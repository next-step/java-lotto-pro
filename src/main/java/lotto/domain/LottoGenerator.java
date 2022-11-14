package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.Lotto.LOTTO_SIZE;
import static lotto.domain.Number.MAXIMUM_NUMBER;
import static lotto.domain.Number.MINIMUM_NUMBER;

public class LottoGenerator {
    public static final String PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE = "1개 이상부터 구매가능합니다.";
    public static final int ZERO = 0;
    private static final List<Integer> RANGES;

    static {
        List<Integer> ranges = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            ranges.add(i);
        }
        RANGES = ranges;
    }

    public static Lottos generate(int generateCount) throws IllegalArgumentException {
        validateGenerateCount(generateCount);
        return createLottos(generateCount);
    }

    private static void validateGenerateCount(int generateCount) {
        if (generateCount <= ZERO) {
            throw new IllegalArgumentException(PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE);
        }
    }

    private static Lottos createLottos(int generateCount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < generateCount; i++) {
            lottos.add(createLotto());
        }
        return lottos;
    }

    private static Lotto createLotto() {
        Collections.shuffle(RANGES);
        return new Lotto(RANGES.subList(ZERO, LOTTO_SIZE));
    }
}
