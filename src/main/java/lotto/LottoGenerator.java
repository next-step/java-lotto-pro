package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> range = new ArrayList<>();
    private int purchaseCount;

    public LottoGenerator(int purchaseCount) {
        init(purchaseCount);
    }

    private void init(int purchaseCount) {
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.range.add(i);
        }
        this.purchaseCount = purchaseCount;
    }

    public List<Lottos> generateLottoses() {
        List<Lottos> lottosList = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            lottosList.add(generateLottos());
        }
        return lottosList;
    }

    private Lottos generateLottos() {
        Collections.shuffle(this.range);
        return new Lottos(this.range.subList(0, 6));
    }
}
