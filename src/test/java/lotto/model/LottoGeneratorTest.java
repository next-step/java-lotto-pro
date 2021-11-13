package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    @DisplayName("매개변수로 전달한 갯수와 동일한 수의 로또를 반환하는지 테스트")
    void generate() {
        Lottos lottos = LottoGenerator.generate(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("추출할 로또의 갯수를 음수로 전달할 때 예외 발생")
    void generateByNegativeAutoCount() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> LottoGenerator.generate(-1));
    }
}
