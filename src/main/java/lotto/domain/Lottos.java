package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lottos {

    private static final String LOTTOS_NULL_OR_EMPTY_MESSAGE = "";

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private void validate(final List<Lotto> lottos) {
        validateNotNullOrEmpty(lottos);
    }

    private void validateNotNullOrEmpty(List<Lotto> lottos) {
        if (Objects.isNull(lottos) || lottos.isEmpty() || lottos.size() == 0) {
            throw new IllegalArgumentException(LOTTOS_NULL_OR_EMPTY_MESSAGE);
        }
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
