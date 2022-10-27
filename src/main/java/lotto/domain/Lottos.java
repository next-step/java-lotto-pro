package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private final List<Lotto> lottos;
    private final RandomNumberPickStrategy randomNumberPickStrategy;

    public Lottos() {
        lottos = new ArrayList<>();
        randomNumberPickStrategy = new RandomNumberPickStrategy();
    }

    public void buyRandomNumberLottos(int count) {
        IntStream.iterate(0, i -> i + 1)
                .limit(count)
                .mapToObj(i -> new Lotto(randomNumberPickStrategy.pick()))
                .forEach(lottos::add);
    }

    public int getLottosSize() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
