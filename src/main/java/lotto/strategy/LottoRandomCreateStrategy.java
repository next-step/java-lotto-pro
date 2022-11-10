package lotto.strategy;

import static java.util.concurrent.ThreadLocalRandom.current;

import java.util.HashSet;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.LottoNumber;

public class LottoRandomCreateStrategy implements LottoCreateStrategy {

    private final static int MAX_BOUND = 46;
    private final static int ORIGIN = 1;
    private final static int LOTTO_SIZE = 6;

    @Override
    public Lotto create() {
        Set<LottoNumber> result = new HashSet<>();
        while (result.size() < LOTTO_SIZE) {
            result.add(LottoNumber.of(current().nextInt(ORIGIN, MAX_BOUND)));
        }
        return new Lotto(result);
    }
}
