package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.service.AutoLottoNumbersIssuer;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final int amountOfTickets) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountOfTickets; i++) {
            lottoTickets.add(new LottoTicket(AutoLottoNumbersIssuer.issueLottoNumbers()));
        }
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
