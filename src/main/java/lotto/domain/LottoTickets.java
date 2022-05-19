package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int count) {
        this.lottoTickets = new ArrayList<>(generateLottoTickets(count));
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        return IntStream.rangeClosed(0, count - 1)
                .mapToObj(i -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoTickets.size();
    }

    public LottoPrizes matchResults(LottoTicket lastWinningLottoTicket, LottoNumber bonusLottoNumber) {
        return new LottoPrizes(lottoTickets.stream()
                .map(ticket -> ticket.match(lastWinningLottoTicket, hasBonusBallNumber(ticket, bonusLottoNumber)))
                .collect(Collectors.toList()));
    }

    public boolean hasBonusBallNumber(LottoTicket generatedLottoTicket, LottoNumber bonusBallNumber) {
        return generatedLottoTicket.hasBonusBallNumber(bonusBallNumber);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
