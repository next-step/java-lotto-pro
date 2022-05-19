package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.service.AutoNumbersIssuer;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets createAutomatically(final int count) {
        final List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket(new LottoNumbers(AutoNumbersIssuer.issueNumbers())));
        }
        return new LottoTickets(lottoTickets);
    }

    public static LottoTickets createManually(final List<LottoNumbers> manualLottoNumbersList) {
        final List<LottoTicket> manualLottoTickets = new ArrayList<>();
        for (final LottoNumbers manualLottoNumbers : manualLottoNumbersList) {
            manualLottoTickets.add(new LottoTicket(manualLottoNumbers));
        }
        return new LottoTickets(manualLottoTickets);
    }

    public void merge(final LottoTickets target) {
        lottoTickets.addAll(target.lottoTickets);
    }

    public Map<Prize, Integer> prizeMap(final LottoNumbers winningNumbers, final BonusBall bonusBall) {
        final Map<Prize, Integer> prizeMap = emptyPrizeMap();
        for (final LottoTicket lottoTicket : lottoTickets) {
            final Prize prize = lottoTicket.prize(winningNumbers, bonusBall);
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
        for (final Prize prize : Prize.values()) {
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
