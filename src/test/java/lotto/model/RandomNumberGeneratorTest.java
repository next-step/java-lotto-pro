package lotto.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {
    @Test
    @DisplayName("추출된 숫자들이 적절한 갯수와 범위의 값을 가지고 있는지 테스트")
    void generate() {
        Collection<Integer> generatedNumbers = RandomNumberGenerator.generate();
        assertThat(generatedNumbers)
            .hasSize(Lotto.NUMBER_SIZE)
            .allMatch(number -> number >= Number.MIN_NUMBER)
            .allMatch(number -> number <= Number.MAX_NUMBER);
    }
}
