package lotto.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {
    @DisplayName("randomLottoNumberGenerator 로 랜덤한 Integer List 를 생성한 List 사이즈는 6 이다.")
    @Test
    void randomLottoNumberGeneratorSize() {
        RandomLottoNumberGenerator randomLottoNumberGenerator = new RandomLottoNumberGenerator();
        Set<LottoNumber> lottoNumbers = randomLottoNumberGenerator.generate();
        assertThat(lottoNumbers).hasSize(6);
    }
}
