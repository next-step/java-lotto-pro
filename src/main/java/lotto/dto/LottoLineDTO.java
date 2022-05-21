package lotto.dto;

import java.util.List;

public class LottoLineDTO {

    private final List<LottoNumberDTO> lottoLineDTO;

    public LottoLineDTO(List<LottoNumberDTO> lottoLineDTO) {
        this.lottoLineDTO = lottoLineDTO;
    }

    public int getLottoLineSize() {
        return lottoLineDTO.size();
    }

    @Override
    public String toString() {
        return lottoLineDTO.toString();
    }
}
