package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottosList;

    private Lottos(List<Lotto> lottosList) {
        this.lottosList = lottosList;
    }

    public static Lottos from(final List<Lotto> lottosList) {
        return new Lottos(lottosList);
    }

    public static Lottos buy(final int purchaseCount) {
        List<Lotto> lottosList = new AutoLottoPurchaseMachine().generateLottoNumbers(purchaseCount);
        return Lottos.from(lottosList);
    }

    public List<MatchResult> getMatchingCounts(final WinningLotto winningLotto) {
        List<MatchResult> matchingCounts = new ArrayList<>();
        for (Lotto lotto : lottosList) {
            matchingCounts.add(winningLotto.countMatchingNumber(lotto));
        }
        return matchingCounts;
    }

    public int count() {
        return lottosList.size();
    }

    public List<Lotto> getLottosList() {
        return this.lottosList;
    }

    public List<Lotto> addManualLottoNumbers(ManualLottoPurchaseMachine manualLottoPurchaseMachine) {
        for( Lotto lotto : manualLottoPurchaseMachine.getManualLottoNumbers() ) {
            this.lottosList.add(lotto);
        }
        return this.lottosList;
    }
}
