package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class LottoGenerator {
    private final Payment payment;

    public LottoGenerator(Payment payment) {
        Objects.requireNonNull(payment);
        this.payment = payment;
    }

    public Collection<Lotto> generate() {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCount = payment.countLotto();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(RandomNumberGenerator.generate()));
        }
        return lottos;
    }
}
