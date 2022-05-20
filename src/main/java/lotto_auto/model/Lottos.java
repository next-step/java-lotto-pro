package lotto_auto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> list) {
        this.lottoList = Collections.unmodifiableList(list);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Lottos merge(Lottos lottos) {
        List<Lotto> newLottos =
                Stream.of(lottoList, lottos.getLottoList())
                        .flatMap(List::stream)
                        .collect(Collectors.toList());
        return new Lottos(newLottos);
    }

    public Figures matchedLottos(WinningLotto winningLotto) {
        Map<LottoRank, Integer> figure = lottoList.stream()
                .map(winningLotto::matches)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));

        return new Figures(figure);
    }

}
