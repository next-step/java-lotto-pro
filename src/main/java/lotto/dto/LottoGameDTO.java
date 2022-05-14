package lotto.dto;

import lotto.model.Lottos;

public class LottoGameDTO {

    private final Lottos lottos;
    private final boolean isInputError;

    public LottoGameDTO(boolean isInputError){
        this(null,isInputError);
    }
    public LottoGameDTO(Lottos lottos, boolean isInputError) {
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
