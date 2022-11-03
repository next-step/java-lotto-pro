package lotto.domain;


import java.util.*;
import java.util.stream.Collectors;

public class LottoBundle {
    private final List<Lotto> lottoTickets;

    public LottoBundle(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoBundle(final List<Lotto> lottoTickets, final List<Lotto> lottoTickets1) {
        List<Lotto> allLottoTickets = new ArrayList<>(lottoTickets);
        allLottoTickets.addAll(lottoTickets1);
        this.lottoTickets = allLottoTickets;
    }
    public static LottoBundle merge(LottoBundle bundle1, LottoBundle bundle2) {
        return new LottoBundle(bundle1.getLottoTickets(), bundle2.getLottoTickets());
    }

    public int size() {
        return lottoTickets.size();
    }

    public WinningMoney countWinning(WinningLotto winningLotto) {
        List<Rank> ranks = lottoTickets.stream()
                .map(lotto -> lotto.getRankBy(winningLotto))
                .filter(rank -> rank != Rank.FAIL)
                .collect(Collectors.toList());
        return new WinningMoney(ranks);
    }

    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }
}
