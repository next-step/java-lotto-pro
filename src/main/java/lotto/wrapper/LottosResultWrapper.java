package lotto.wrapper;

import lotto.model.Lottos;

public class LottosResultWrapper {

    private final Lottos lottos;
    private final boolean isInputError;

    public LottosResultWrapper(Lottos lottos, boolean isInputError) {
        this.lottos = lottos;
        this.isInputError = isInputError;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public boolean isInputError() {
        return isInputError;
    }
}
