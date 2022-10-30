package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class AutoLottoGenerator implements LottoGenerator {
    private static final List<Number> LOTTO_NUMBER_CARDS = new ArrayList<>();
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    static {
        for (int i = LOTTO_FIRST_NUMBER; i <= LOTTO_LAST_NUMBER; i++) {
            LOTTO_NUMBER_CARDS.add(new Number(i));
        }
    }

    @Override
    public Lotto generateLotto() {
        Collections.shuffle(LOTTO_NUMBER_CARDS);
        return new Lotto(new ArrayList<>(new TreeSet<>(LOTTO_NUMBER_CARDS.subList(0, 6))));
    }
}
