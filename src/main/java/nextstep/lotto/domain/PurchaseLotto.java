package nextstep.lotto.domain;

import java.util.Iterator;
import java.util.List;

public class PurchaseLotto implements Iterable<Lotto> {

    private final List<Lotto> purchaseLotto;

    public PurchaseLotto(List<Lotto> purchaseLotto) {
        this.purchaseLotto = purchaseLotto;
    }

    public Integer size() {
        return purchaseLotto.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return purchaseLotto.iterator();
    }
}
