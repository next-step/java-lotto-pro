package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {
    @RepeatedTest(value = 1000)
    @DisplayName("생성한 무작위 번호는 항상 1 이상 45 이하의 값이어야 한다")
    void generate() {
        final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        final int randomNumber = lottoNumberGenerator.generate();
        assertThat(randomNumber).isGreaterThanOrEqualTo(1);
        assertThat(randomNumber).isLessThanOrEqualTo(45);
    }
}
