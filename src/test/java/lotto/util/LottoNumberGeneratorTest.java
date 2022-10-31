package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @Test
    public void generateLottoNumbersTest() {
        Set<Integer> uniqueNumbers = new HashSet<>(LottoNumberGenerator.generateLottoNumbers());
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }
}