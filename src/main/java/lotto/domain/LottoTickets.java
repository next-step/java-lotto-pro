package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Map<Prize, Integer> prizeMap(final LottoNumbers winningNumbers) {
        final Map<Prize, Integer> prizeMap = emptyPrizeMap();
        for (final LottoTicket lottoTicket : lottoTickets) {
            final Prize prize = lottoTicket.prize(winningNumbers);
            prizeMap.put(prize, prizeMap.get(prize) + 1);
        }
        prizeMap.remove(Prize.NO_MATCHES);
        return prizeMap;
    }

    public void print() {
        for (final LottoTicket ticket : lottoTickets) {
            ticket.print();
        }
    }

    private Map<Prize, Integer> emptyPrizeMap() {
        final Map<Prize, Integer> emptyPrizeMap = new HashMap<>();
        for (Prize prize : Prize.values()) {
            emptyPrizeMap.put(prize, 0);
        }
        return emptyPrizeMap;
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "lottoTickets=" + lottoTickets +
                '}';
    }
}
