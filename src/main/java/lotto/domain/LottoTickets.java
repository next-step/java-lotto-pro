package lotto.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(LottoTickets manualTickets, LottoTickets autoTickets) {
        this.lottoTickets = manualTickets.merge(autoTickets);
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> merge(LottoTickets otherTickets) {
        return Stream.of(lottoTickets, otherTickets.lottoTickets)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
    }

    public LottoRanks lottoResult(LottoTicket lottoWinningTicket, LottoNumber bonusNumber) {
        List<LottoRank> lottoRanks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            int match = lottoTicket.match(lottoWinningTicket);
            boolean hasBonus = lottoTicket.contains(bonusNumber);
            lottoRanks.add(LottoRank.valueOf(match, hasBonus));
        }
        return new LottoRanks(lottoRanks);
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
            "lottoTickets=" + lottoTickets +
            '}';
    }

    public int size() {
        return lottoTickets.size();
    }
}
