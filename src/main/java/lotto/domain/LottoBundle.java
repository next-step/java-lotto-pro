package lotto.domain;


import java.util.List;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoTickets;

    public LottoBundle(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }

    public WinningMoney countWinning(Lotto winningLotto) {
        List<Integer> matchCounts = lottoTickets.stream()
                .map(lotto -> lotto.compareMatchCount(winningLotto))
                .collect(Collectors.toList());
        return new WinningMoney(matchCounts);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
