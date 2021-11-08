package lotto.dto;

import lotto.domain.LottoNumber;

import java.util.List;

public class LottoTicketDTO {
    private final List<LottoNumberDTO> lottoNumbers;

    public LottoTicketDTO(List<LottoNumberDTO> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public String toResultString() {
        return lottoNumbers.toString();
    }

}
