package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private List<Lotto> lottoList;

    private Lottos() { }

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos generate(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public List<Integer> getMatchCounts(Numbers numbers) {
        return lottoList.stream()
                .map(lotto -> lotto.getMatchCount(numbers))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return lottoList.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }
}
