package generator;

import static lotto.constants.LottoNumberConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    @DisplayName("LottoNumberGenerate를 이용해 6개 로또번호를 생성하는 테스트")
    void generate01() {
        // given
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        // when
        List<Integer> generateLottoNumbers = numberGenerator.generate();

        // then
        assertThat(generateLottoNumbers).hasSize(LOTTO_NUMBER_SIZE);
    }
}