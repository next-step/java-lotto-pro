package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private static List<Lotto> auto(int count) {
        return IntStream.range(0, count)
                .mapToObj(value -> Lotto.auto())
                .collect(Collectors.toList());
    }

    public static Lottos buy(LottoCharge charge) {
        return new Lottos(auto(charge.count()));
    }

    public static Lottos buy(List<Lotto> manualLottos, LottoCharge restCharge) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(auto(restCharge.count()));
        return new Lottos(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public Winnings winnigs(Answer answer) {
        return new Winnings(lottos.stream()
                .map(answer::winning)
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        return lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
