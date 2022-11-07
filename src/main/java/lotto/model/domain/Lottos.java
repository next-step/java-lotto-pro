package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public boolean addLotto(Lotto lotto) {
        if (this.lottos == null) {
            this.lottos = new ArrayList<>();
        }
        if (!lottos.contains(lotto)) {
            this.lottos.add(lotto);
            return true;
        }
        return false;
    }

    public MatchCounts compareWinLotto(WinLotto winLotto) {
        MatchCounts matchCounts = new MatchCounts();
        for (Lotto lotto : this.lottos) {
            matchCounts.addMatchCount(winLotto.compareWithLotto(lotto));
        }
        return matchCounts;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
