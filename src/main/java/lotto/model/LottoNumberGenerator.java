package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class LottoNumberGenerator {
    private final Payment payment;

    public LottoNumberGenerator(Payment payment) {
        Objects.requireNonNull(payment);
        this.payment = payment;
    }

    public Collection<LottoNumbers> generate() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        int lottoCount = payment.countLotto();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new LottoNumbers(RandomNumberSupplier.generate()));
        }
        return lottoNumbers;
    }
}
