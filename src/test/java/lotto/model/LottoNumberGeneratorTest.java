package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    private static final int PAYMENT = 14000;

    @Test
    void getLottoNumbersCollection() {
        assertThat(
            new LottoNumberGenerator(PAYMENT).getLottoNumbersCollection()
        ).hasSize(PAYMENT / Payment.LOTTO_PRICE);
    }
}
