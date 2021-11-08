package lotto.dto;

import lotto.domain.LottoNumber;

import java.util.List;

public class LottoTicketDTO {
    private final List<LottoNumber> lottoNumbers;

    public LottoTicketDTO(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
