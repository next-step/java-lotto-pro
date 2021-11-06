package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    void getLottoNumbersCollection() {
        assertThat(new LottoNumberGenerator(14000).getLottoNumbersCollection()).hasSize(14000 / Payment.LOTTO_PRICE);
    }
}
