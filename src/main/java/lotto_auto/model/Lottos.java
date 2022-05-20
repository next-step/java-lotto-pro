package lotto_auto.model;

import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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
        Map<LottoRank, Integer> figure = new EnumMap<>(LottoRank.class);

        for (Lotto lotto : lottoList) {
            LottoRank rank = winningLotto.matches(lotto);
            int count = figure.getOrDefault(rank, Figures.DEFAULT_RANK_COUNT);
            figure.put(rank, count+1);
        }

        return new Figures(figure);
    }

}
