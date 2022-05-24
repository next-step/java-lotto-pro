package step3.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import step3.domain.LottoElement;
import step3.domain.LottoTicket;

public class LottoTickets {
    private List<LottoTicket> lottoTickets = new ArrayList<>();


    public void addLottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets.addAll(lottoTickets);
    }

    public List<List<LottoElement>> getLottoNumbers() {
        return lottoTickets.stream().map(LottoTicket::getLottoNumbers).collect(Collectors.toList());
    }
    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

}
