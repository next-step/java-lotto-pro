package lotto.dto;

import java.util.List;
import lotto.domain.LottoLine;

public class LottoGameDTO {
    private final List<LottoLineDTO> lottoGameDTO;

    public LottoGameDTO(List<LottoLineDTO> LottoLineDTO) {
        this.lottoGameDTO = LottoLineDTO;
    }

    public List<LottoLineDTO> getLottoGameDTO() {
        return lottoGameDTO;
    }

    public int size(){
        return  lottoGameDTO.size();
    }
}
