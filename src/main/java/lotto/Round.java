package lotto;

import static java.util.Objects.requireNonNull;

public class Round {

    private final Lottos lottos;

    private Round(final Lottos lottos) {
        this.lottos = lottos;
    }

    public static Round start(final Lottos lottos) {
        validateStart(requireNonNull(lottos));
        return new Round(lottos);
    }

    private static void validateStart(final Lottos lottos) {
        if (lottos.size() < 1) {
            throw new IllegalArgumentException("로또가 없습니다.");
        }
    }
    public int purchaseSize() {
        return lottos.size();
    }

    public Lottos lottos() {
        return this.lottos;
    }

}
