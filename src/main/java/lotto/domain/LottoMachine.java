package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.shuffle;

public class LottoMachine {
    private final static List<Integer> lottoNumberPool = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public List<Lotto> auto(int lottoTicketCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(issue());
        }
        return lottoTickets;
    }

    public Lotto issue() {
        shuffle(lottoNumberPool);
        return new Lotto(lottoNumberPool.subList(0, 6));
    }
}
