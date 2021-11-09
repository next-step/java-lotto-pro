package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LottoNumberGenerator {
    static final String INPUT_MONEY_ERR_MSG = "구입 금액으로 숫자만 입력해야 합니다.";

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
