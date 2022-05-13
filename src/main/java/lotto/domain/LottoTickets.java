package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.service.AutoLottoNumbersIssuer;

public class LottoTickets {
    public static final int[] MATCH_COUNTS = {3, 4, 5, 6};

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final int amountOfTickets) {
        lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountOfTickets; i++) {
            lottoTickets.add(new LottoTicket(AutoLottoNumbersIssuer.issueLottoNumbers()));
        }
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
