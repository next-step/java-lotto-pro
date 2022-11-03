package lotto.model.vo;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.LottoRun;
import lotto.model.dto.WinLotto;

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

    public void print() {
        for (Lotto lotto : this.lottos) {
            lotto.print();
        }
    }

    public MatchCounts compareWinLotto(WinLotto winLotto) {
        MatchCounts matchCounts = new MatchCounts();
        for (Lotto lotto : this.lottos) {
            matchCounts.addMatchCount(LottoRun.countMatchNumber(winLotto, lotto));
        }
        return matchCounts;
    }
}
