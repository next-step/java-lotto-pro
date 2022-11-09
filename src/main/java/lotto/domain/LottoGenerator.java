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
    public static final String NULL_EXCEPTION_MESSAGE = "null 일 수 없습니다.";

    public LottoGenerator() {
    }

    public static Lottos generate(int generateCount) {
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
        List<Integer> ranges = ranges();
        Collections.shuffle(ranges);
        return new Lotto(ranges.subList(ZERO, LOTTO_SIZE));
    }

    private static List<Integer> ranges() {
        final List<Integer> ranges = new ArrayList<>();
        for (int i = MINIMUM_NUMBER; i <= MAXIMUM_NUMBER; i++) {
            ranges.add(i);
        }
        return ranges;
    }
}
