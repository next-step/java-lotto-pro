package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE = "1개 이상부터 구매가능합니다.";
    public static final int ZERO = 0;
    private final List<Integer> range = new ArrayList<>();

    public LottoGenerator() {
        init();
    }

    private void init() {

        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.range.add(i);
        }
    }

    public List<Lotto> generate(int purchaseCount) {
        if (purchaseCount <= ZERO) {
            throw new IllegalArgumentException(PURCHASE_MINIMUM_COUNT_EXCEPTION_MESSAGE);
        }
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private Lotto generateLotto() {
        Collections.shuffle(this.range);
        return new Lotto(this.range.subList(0, 6));
    }
}
