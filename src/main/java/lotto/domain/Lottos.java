package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private static Lottos auto(int count) {
        return new Lottos(IntStream.range(0, count)
                .mapToObj(value -> Lotto.auto())
                .collect(Collectors.toList()));
    }

    public static Lottos buy(LottoCharge charge) {
        return auto(charge.count());
    }

    public int count() {
        return lottos.size();
    }

    public Winnings winnigs(Lotto answer) {
        return new Winnings(lottos.stream()
                .map(lotto -> lotto.winning(answer))
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
