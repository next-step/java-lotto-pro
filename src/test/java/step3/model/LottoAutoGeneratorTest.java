package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_생성_클래스")
public class LottoAutoGeneratorTest {
    @DisplayName("로또생성 테스트")
    @Test
    void createLottoResult_pass_01() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThatNoException().isThrownBy(lottoGenerator::createLottoResult);
    }
}
