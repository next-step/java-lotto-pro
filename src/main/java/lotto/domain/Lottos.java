package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final String MIN_PAYMENT_REQUIRED_MESSAGE = "로또 구입을 위해서는 최소 1000원 이상의 구입금액이 필요합니다.";
    private static final int UNIT_PRICE_PER_LOTTO = 1000;
    private List<Lotto> lottos;

    public Lottos(Payment payment) {
        validateMinPayment(payment);
        this.lottos = generateLottos(payment);
    }

    private void validateMinPayment(Payment payment) {
        if (payment.getPayment() < UNIT_PRICE_PER_LOTTO) {
            throw new IllegalArgumentException(MIN_PAYMENT_REQUIRED_MESSAGE);
        }
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

    public List<Lotto> getLottoList() {
        return this.lottos;
    }
}
