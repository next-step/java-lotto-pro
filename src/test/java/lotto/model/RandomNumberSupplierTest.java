package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RandomNumberSupplierTest {
    @Test
    void generateNumbers() {
        assertThat(RandomNumberSupplier.generateNumbers())
            .hasSize(LottoNumbers.NUMBER_SIZE)
            .allMatch(number -> number.compareTo(Number.ofValue(Number.MIN_NUMBER)) >= 0)
            .allMatch(number -> number.compareTo(Number.ofValue(Number.MAX_NUMBER)) <= 0);
    }
}
