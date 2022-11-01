package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.LottoGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("로또 금액 빈값, 숫자 테스트")
    void 로또_금액_빈값_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice("로또"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액 최소 테스트")
    void 로또_금액_최소_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePrice("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 때 최대수량 발급 테스트")
    void 로또_금액_단위_불일치_테스트() {
        lottoGenerator.setPurchasePrice("14900");
        lottoGenerator.generateLottos();
        assertThat(lottoGenerator.getPurchasedCount()).isEqualTo(14);
    }
}
