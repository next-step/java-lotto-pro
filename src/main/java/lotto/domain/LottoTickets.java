package lotto.domain;

import lotto.view.ResultView;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int count) {
        this.lottoTickets = Collections.unmodifiableList(generateLottoTickets(count));
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        return IntStream.rangeClosed(0, count - 1)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoPrize> matchResults(LottoTicket lottoTicket) {
        return lottoTickets.stream()
                .map(ticket -> ticket.match(lottoTicket))
                .collect(Collectors.toList());
    }

    public void printLottoTickets() {
        for (LottoTicket lotto : lottoTickets) {
            ResultView.printLottoTicket(lotto);
        }
    }
}
