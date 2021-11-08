package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    public Lottos(IssueQuantity issueQuantity, List<List<Integer>> manualNumbers) {
        this.lottos = buyLotto(issueQuantity, manualNumbers);
    }

    public static List<Lotto> buyLotto(IssueQuantity issueQuantity, List<List<Integer>> manualNumbers) {
        List<Lotto> lottos = new ArrayList<Lotto>();
        for (int i = 0; i < issueQuantity.getManualQuantity(); i++) {
        	lottos.add(Lotto.buyManual(manualNumbers.get(i)));
		}
        for (int i = 0; i < issueQuantity.getAutoQuantity(); i++) {
            lottos.add(Lotto.buyAuto());
        }
        return lottos;
    }
    
    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void execute(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            lotto.judgeRank(winningLotto);
        }
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

}
