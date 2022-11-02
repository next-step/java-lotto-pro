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
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndSelfCount("", "0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndSelfCount("로또", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액 최소 테스트")
    void 로또_금액_최소_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndSelfCount("500", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 때 최대수량 발급 테스트")
    void 로또_금액_단위_불일치_테스트() {
        lottoGenerator.setPurchasePriceAndSelfCount("14900", "0");
        lottoGenerator.generateLottos();
        assertThat(lottoGenerator.getPurchasedCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("수동 로또 수량 빈값, 숫자 테스트")

    void 수동_로또_수량_빈값_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndSelfCount("1000", ""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndSelfCount("1000", "로또"))
                .isInstanceOf(IllegalArgumentException.class);

        lottoGenerator.setPurchasePriceAndSelfCount("2000", "0");
        assertThat(lottoGenerator.getSelfCount()).isEqualTo(0);

        lottoGenerator.setPurchasePriceAndSelfCount("2000", "2");
        assertThat(lottoGenerator.getSelfCount()).isEqualTo(2);
    }
}
