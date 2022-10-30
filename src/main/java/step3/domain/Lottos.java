package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Rank> getRanks(Numbers numbers) {
        return lottos.stream()
                .map(lotto -> lotto.getCountOfMatch(numbers))
                .map(Rank::valueOf)
                .filter(rank -> !rank.equals(Rank.MISS))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
