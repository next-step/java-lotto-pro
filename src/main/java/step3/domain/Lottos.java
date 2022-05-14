package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int DEFAULT_LOTTO_COUNT = 1;
    private final List<Lotto> lottos;

    public Lottos() {
        this(DEFAULT_LOTTO_COUNT);
    }

    public Lottos(final int lottoCount) {
        this.lottos = createLottos(lottoCount);
    }

    private List<Lotto> createLottos(final int lottoCount) {
        final List<Lotto> lottos = new ArrayList<>();
        for(int i= 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int size() {
        return lottos.size();
    }
}
