package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos buy(final int count) {
        List<Lotto> lottosList = new ArrayList<>();
        for( int i = 0; i < count; i++ ) {
            Lotto lotto = Lotto.from(new AutoLottoPurchase().generateLottoNumbers());
            lottosList.add(lotto);
        }
        return Lottos.from(lottosList);
    }

    public List<MatchResult> getMatchingCounts(final Lotto winningLotto) {
        List<MatchResult> matchingCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchingCounts.add(winningLotto.countMatchingNumber(lotto));
        }
        return matchingCounts;
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
