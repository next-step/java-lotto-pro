package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoTickets;

    public LottoBundle(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<String> printAll() {
        return lottoTickets.stream()
                .map(Lotto::print)
                .collect(Collectors.toList());
    }

    public int size(){
        return lottoTickets.size();
    }

    public List<Integer> checkAll(List<Integer> winningNumber) {
        return lottoTickets.stream()
                .map(t -> t.check(winningNumber))
                .collect(Collectors.toList());
    }
}
