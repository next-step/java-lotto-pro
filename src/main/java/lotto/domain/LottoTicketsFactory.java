package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.service.AutoNumbersIssuer;

public class LottoTicketsFactory {
    public LottoTickets createAutomatically(final int count) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers(AutoNumbersIssuer.issueNumbers())));
        }
        return new LottoTickets(lottoTickets);
    }
}
