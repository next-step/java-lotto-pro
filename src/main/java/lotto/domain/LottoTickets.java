package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(int count) {
        this.lottoTickets = generateLottoTickets(count);
    }

    private List<LottoTicket> generateLottoTickets(int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public List<LottoPrize> matchResults(LottoTicket lottoTicket) {
        List<LottoPrize> matchResult = new ArrayList<>();
        for (LottoTicket lotto : lottoTickets) {
            matchResult.add(lotto.match(lottoTicket));
        }

        return matchResult;
    }

    public void printLottoTickets() {
        for (LottoTicket lotto : lottoTickets) {
            System.out.println(lotto.toString());
        }
    }
}
