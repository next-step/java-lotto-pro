package lotto.domain.lotto;

import lotto.prize.Prize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeOfLotto(Lotto winnerLotto) {
        Map<Prize, Integer> prizes = new HashMap<>();
        this.lottos.stream()
                .map(v -> v.matchCount(winnerLotto))
                .filter(Prize.matchCounts::containsKey)
                .sorted()
                .forEach(v -> prizes.merge(Prize.matchCounts.get(v), 1, Integer::sum));
        return prizes;
    }
}
