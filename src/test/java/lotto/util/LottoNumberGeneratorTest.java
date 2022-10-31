package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @Test
    public void generateLottoNumbersTest() {
        Lotto lotto = LottoNumberGenerator.generateLottoNumbers();
        Set<LottoNumber> uniqueNumbers = new HashSet<>(lotto.getLottoNumbers());
        assertThat(uniqueNumbers.size()).isEqualTo(6);
    }
}