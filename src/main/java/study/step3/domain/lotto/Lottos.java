package study.step3.domain.lotto;

import study.step3.domain.lottonumber.LottoNumbers;
import study.step3.domain.lottostatistics.LottoRankCountCache;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int size() {
        return this.lottos.size();
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        for (Lotto lotto : lottos) {
            output.append("[").append(lotto.reportLottoNumbers()).append("]").append("\n");
        }
        return output.toString();
    }

    public LottoRankCountCache matchAll(Lotto winningLotto) {
        List<Long> matchCounts = this.lottos.stream()
                .map(lotto -> lotto.match(winningLotto))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
        return LottoRankCountCache.of(matchCounts);
    }
}
