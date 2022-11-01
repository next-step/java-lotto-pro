package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private static final int UNIT_PRICE_PER_LOTTO = 1000;
    private List<Lotto> lottos;

    public Lottos(Payment payment) {
        this.lottos = generateLottos(payment);
    }

    private List<Lotto> generateLottos(Payment payment) {
        lottos = new ArrayList<>();
        int rotate = payment.getPayment() / UNIT_PRICE_PER_LOTTO;
        for (int i = 0; i < rotate; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public int getLottosSize() {
        return this.lottos.size();
    }
}
