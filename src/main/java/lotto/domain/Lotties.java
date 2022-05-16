package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotties {

    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        validate(lotties);
        this.lotties = lotties;
    }

    private void validate(List<Lotto> lotties) {
        if (lotties.isEmpty()) {
            throw new IllegalArgumentException("로또는 1개 이상 구매해야 합니다.");
        }
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public int count() {
        return lotties.size();
    }

    public WinningStatus getWinningStatus(Lotto winningLotto) {
        List<Rank> ranks = lotties.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
        return WinningStatus.from(ranks);
    }
}
