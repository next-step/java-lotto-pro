package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private static List<Lotto> auto(Count count) {
        return count.toList(Lotto::auto);
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
