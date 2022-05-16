package lotto.controller.dto;

import java.util.List;

public class LottoTicketsDTO {
    List<LottoNumbersDTO> lottoTickets;

    public LottoTicketsDTO(List<LottoNumbersDTO> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoNumbersDTO> getLottoTickets() {
        return lottoTickets;
    }

    public void setLottoTickets(List<LottoNumbersDTO> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }
}
