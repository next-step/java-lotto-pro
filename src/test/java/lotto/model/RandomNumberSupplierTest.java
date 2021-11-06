package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import lotto.model.RandomNumberSupplier.RandomNumberSupplierBuilder;

public class RandomNumberSupplierTest {
    @ParameterizedTest
    @CsvSource(value = {"0:1:45", "6:45:1", "100:1:45"}, delimiter = ':')
    void 객체_생성_시_유효성_검사(int size, int startInclusive, int endInclusive) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            new RandomNumberSupplierBuilder().withSize(size).withRange(startInclusive, endInclusive).build());
    }

    @Test
    void getNumbers() {
        RandomNumberSupplier numberSupplier = new RandomNumberSupplierBuilder().withSize(6).withRange(1, 45).build();
        assertThat(numberSupplier.getNumbers())
            .hasSize(6)
            .allMatch(number -> number.compareTo(new Number(1)) >= 0)
            .allMatch(number -> number.compareTo(new Number(45)) <= 0);
    }
}
