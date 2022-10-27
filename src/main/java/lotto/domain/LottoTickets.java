package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final String NEXT_LINE = "\n";
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottoTickets.forEach(lottoTicket -> {
            stringBuilder.append(lottoTicket.toString());
            stringBuilder.append(NEXT_LINE);
        });
        return stringBuilder.toString();
    }

    public List<Integer> match(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
            .map(winningLottoTicket::matchCount)
            .collect(Collectors.toList());

    }
}