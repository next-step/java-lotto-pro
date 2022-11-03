package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final String NEXT_LINE = "\n";
    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public static LottoTickets from(List<LottoTicket> lottoTickets) {
        return new LottoTickets(lottoTickets);
    }

    public int count() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
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

    public Ranks ranks(WinningLottoTicket winningLottoTicket) {
        return lottoTickets.stream()
            .map(winningLottoTicket::rank)
            .collect(Collectors.collectingAndThen(Collectors.toList(), Ranks::from));
    }
}