package lotto.dto;

import lotto.model.Lottos;

public class LottoGameDTO {

    private final Lottos lottos;
    private final String view;
    private final boolean isInputError;

    public LottoGameDTO(Lottos lottos, String view, boolean isInputError) {
        this.view = view;
        this.lottos = lottos;
        this.isInputError = isInputError;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public String getView() {
        return view;
    }

    public boolean isInputError() {
        return isInputError;
    }
}
