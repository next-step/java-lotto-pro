package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @Test
    @DisplayName("로또 번호들은 6개이어야 한다.")
    void generate_test() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }
}
