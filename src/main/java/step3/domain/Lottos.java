package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos generate(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public List<Rank> getRanks(Numbers numbers) {
        return lottoList.stream()
                .map(lotto -> lotto.getCountOfMatch(numbers))
                .map(Rank::valueOf)
                .filter(rank -> !rank.equals(Rank.MISS))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
