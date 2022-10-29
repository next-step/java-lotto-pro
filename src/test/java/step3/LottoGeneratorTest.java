package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoGenerator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("로또 금액 유효성 테스트")
    void 로또_금액_유효성_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice("500"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice("로또"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
