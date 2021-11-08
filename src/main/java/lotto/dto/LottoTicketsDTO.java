package lotto.dto;

import java.util.List;

public class LottoTicketsDTO {
    private final List<LottoTicketDTO> lottoTickets;

    public LottoTicketsDTO(List<LottoTicketDTO> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicketDTO> getLottoTickets() {
        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }
}
