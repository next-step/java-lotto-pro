package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_생성_클래스")
public class LottoGeneratorTest {
    @DisplayName("로또생성 테스트")
    @Test
    void createLotto_pass_01() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatNoException().isThrownBy(lottoGenerator::createLotto);
    }
}
