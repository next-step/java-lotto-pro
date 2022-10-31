package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.LottoGenerator;
import step3.domain.Lottos;

public class LottoGeneratorTest {

    @Test
    @DisplayName("입력된 숫자만큼 로또를 생성해주는 테스트")
    void makeLottos() {
        Lottos lottos = LottoGenerator.createLottos(6);
        assertThat(lottos.getLottoList().size()).isEqualTo(6);
    }
}
