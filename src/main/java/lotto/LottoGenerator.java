package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static final int MINIMUM_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> range = new ArrayList<>();

    public LottoGenerator() {
        init();
    }

    private void init() {
        for (int i = MINIMUM_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.range.add(i);
        }
        Collections.shuffle(this.range);
    }

    public List<Integer> geneate() {
        return this.range.subList(0, 6);
    }
}
