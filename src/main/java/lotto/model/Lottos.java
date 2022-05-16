package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(PurchasePrice purchasePrice) {
        this.lottos = new ArrayList<>();

        int count = purchasePrice.purchaseLottoCount();
        for (int i = 0; i < count; i++) {
            this.lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottosCount() {
        return this.lottos.size();
    }

    public WinningStatus compareLottos(WinningLotto winningLotto) {
        WinningStatus winningStatus = new WinningStatus();

        for (Lotto lotto : this.lottos) {
            int count = winningLotto.compareMatchPointCount(lotto);
            boolean matchBonus = winningLotto.isMatchBonus(lotto);

            winningStatus.recordResults(count, matchBonus);
        }

        return winningStatus;
    }

    public String numbersToString() {
        StringBuilder sb = new StringBuilder();

        for (Lotto lotto : this.lottos) {
            sb.append(lotto.numbersToString());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }
}
