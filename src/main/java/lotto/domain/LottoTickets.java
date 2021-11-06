package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets generateRandomLottoTickets(int amount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoTickets.add(LottoTicket.generateRandomLottoTicket());
        }
        return new LottoTickets(lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public String toResultString() {
        List<String> resultStrings = lottoTickets.stream()
                .map(LottoTicket::toResultString)
                .collect(Collectors.toList());
        return String.join("\n", resultStrings);
    }
}
