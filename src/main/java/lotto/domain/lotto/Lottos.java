package lotto.domain.lotto;

import lotto.prize.Prizes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = Collections.unmodifiableList(new ArrayList<>(lottos));
    }

    public Lottos(List<Lotto> autoLottos, List<Lotto> manualLottos) {
        this.lottos = Stream.concat(autoLottos.stream(), manualLottos.stream())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Prizes getPrizeOfLotto(Lotto winnerLotto) {
        return new Prizes(lottos.stream()
                .map(winnerLotto::matchPrize)
                .collect(Collectors.toList()));
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
