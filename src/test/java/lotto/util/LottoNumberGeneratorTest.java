package lotto.util;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @Test
    public void generateLottoNumbersTest() {
        List<Integer> lotto = LottoNumberGenerator.generateLottoNumbers();
        Set<Integer> uniqueNumbers = Sets.newHashSet(lotto);
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }
}