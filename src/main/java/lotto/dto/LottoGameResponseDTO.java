package lotto.dto;

import lotto.vo.Lottos;

public class LottoGameResponseDTO {

    private final Lottos lottos;
    private final String view;
    private final boolean isInputError;

    public LottoGameResponseDTO(Lottos lottos,String view,boolean isInputError) {
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
