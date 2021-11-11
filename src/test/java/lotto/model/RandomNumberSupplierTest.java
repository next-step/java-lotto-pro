package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberSupplierTest {
    @Test
    @DisplayName("추출된 숫자들이 적절한 갯수와 범위의 값을 가지고 있는지 테스트")
    void generate() {
        Set<Number> generatedNumbers = RandomNumberSupplier.generate();
        assertThat(generatedNumbers)
            .hasSize(LottoNumbers.NUMBER_SIZE)
            .allMatch(number -> number.compareTo(Number.of(Number.MIN_NUMBER)) >= 0)
            .allMatch(number -> number.compareTo(Number.of(Number.MAX_NUMBER)) <= 0);
    }
}
