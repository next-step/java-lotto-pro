package lotto.domain;


import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoTickets;

    public LottoBundle(List<Lotto> lottoTickets) {
        this.lottoTickets = Collections.unmodifiableList(lottoTickets);
    }

    public List<String> printAll() {
        return lottoTickets.stream()
                .map(Lotto::print)
                .collect(Collectors.toList());
    }

    public int size() {
        return lottoTickets.size();
    }

    private List<Integer> checkAll(List<Integer> winningNumber) {
        return lottoTickets.stream()
                .map(t -> t.check(winningNumber))
                .collect(Collectors.toList());
    }

    public WinningMoney countWinning(List<Integer> winningNumber) {
        List<Integer> matchCountsPerLotto = this.checkAll(winningNumber);
        return new WinningMoney(matchCountsPerLotto);
    }
}
