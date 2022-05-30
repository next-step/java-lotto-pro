package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
        this.lottoTickets = join(manualTickets, autoTickets);
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> join(List<LottoTicket> manualTickets, List<LottoTicket> autoTickets) {
        return Stream.concat(manualTickets.stream(), autoTickets.stream())
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
