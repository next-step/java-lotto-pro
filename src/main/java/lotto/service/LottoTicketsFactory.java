package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

public class LottoTicketsFactory {
    public LottoTickets createAutomatically(final int count) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket(AutoLottoNumbersIssuer.issueLottoNumbers()));
        }
        return new LottoTickets(lottoTickets);
    }
}
