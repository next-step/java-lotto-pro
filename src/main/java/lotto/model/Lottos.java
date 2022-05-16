package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(PurchasePrice purchasePrice) {
        this.lottos = new ArrayList<>();

        int count = purchasePrice.purchaseLottoCount();
        createLottos(count);
    }

    public Lottos(PurchasePrice purchasePrice, int nonAutoPurchaseCount) {
        this.lottos = new ArrayList<>();

        purchasePrice.validatePurchasePrice(nonAutoPurchaseCount);
        long autoPurchasePrice = purchasePrice.excludePrice((long) nonAutoPurchaseCount * Lotto.LOTTO_PRICE);

        int count = new PurchasePrice(autoPurchasePrice).purchaseLottoCount();
        createLottos(count);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void createLottos(int count) {
        for (int i = 0; i < count; i++) {
            this.lottos.add(new Lotto());
        }
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

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.lottos);
    }
}
