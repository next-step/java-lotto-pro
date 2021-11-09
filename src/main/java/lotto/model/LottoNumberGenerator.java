package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LottoNumberGenerator {
    private final Payment payment;

    public LottoNumberGenerator(Payment payment) {
        this.payment = payment;
    }

    public Collection<LottoNumbers> generateLottoNumbersCollection() {
        List<LottoNumbers> lottoNumbersCollection = new ArrayList<>();
        int lottoCount = payment.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbersCollection.add(new LottoNumbers(RandomNumberSupplier.generateNumbers()));
        }
        return lottoNumbersCollection;
    }
}
