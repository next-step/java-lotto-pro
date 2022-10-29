package lotto.domain.lotto;

import lotto.prize.Prize;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Prize, Integer> getPrizeOfLotto(Lotto winnerLotto) {
        Map<Prize, Integer> prizes = new EnumMap<Prize, Integer>(Prize.class);
        this.lottos.stream()
                .map(v -> v.matchCount(winnerLotto))
                .filter(Prize.matchCounts::containsKey)
                .sorted()
                .forEach(v -> prizes.merge(Prize.matchCounts.get(v), 1, Integer::sum));
        return prizes;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    @Override
    public String toString() {
        return this.lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
