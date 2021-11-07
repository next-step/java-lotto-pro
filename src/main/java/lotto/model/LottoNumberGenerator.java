package lotto.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lotto.model.RandomNumberSupplier.RandomNumberSupplierBuilder;

public class LottoNumberGenerator {
    static final String INPUT_MONEY_ERR_MSG = "구입 금액으로 숫자만 입력해야 합니다.";
    private static final NumberSupplier RANDOM_NUMBER_SUPPLIER = new RandomNumberSupplierBuilder()
        .withSize(LottoNumbers.NUMBER_SIZE).withRange(Number.MIN_NUMBER, Number.MAX_NUMBER).build();

    private final Payment payment;

    public LottoNumberGenerator(Payment payment) {
        this.payment = payment;
    }

    public Collection<LottoNumbers> getLottoNumbersCollection() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        int lottoCount = payment.getLottoCount();
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new LottoNumbers(RANDOM_NUMBER_SUPPLIER));
        }
        return lottoNumbers;
    }
}
