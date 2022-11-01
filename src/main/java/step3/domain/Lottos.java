package step3.domain;

import step3.enums.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<Rank> resultLottoRanks(WinningLotto winningLotto) {
        List<Rank> resultRanks = new ArrayList<>();
        lottos.forEach(lotto -> {
            Rank rank = lotto.match(winningLotto);
            rank.getLottoMatcher().plusLottoCountOne();
            resultRanks.add(rank);
        });
        return resultRanks;
    }

    public Lottos unionLottos(Lottos additionalLottos) {
        List<Lotto> merge = new ArrayList<>();
        merge.addAll(additionalLottos.getLottos());
        merge.addAll(this.lottos);
        return new Lottos(merge);
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

}
