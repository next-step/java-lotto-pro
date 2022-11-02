package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.Lotto;
import step3.model.LottoGenerator;
import step3.model.Lottos;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static step3.constant.Constant.Common.*;

public class LottoGeneratorTest {
    private LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    @DisplayName("로또 금액 빈값, 숫자 테스트")
    void 로또_금액_빈값_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndManualCount("", "0"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndManualCount("로또", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액 최소 테스트")
    void 로또_금액_최소_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndManualCount("500", "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 때 최대수량 발급 테스트")
    void 로또_금액_단위_불일치_테스트() {
        lottoGenerator.setPurchasePriceAndManualCount("14900", "0");
        lottoGenerator.generateLottos();
        assertThat(lottoGenerator.getPurchasedCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("수동 로또 수량 빈값, 숫자 테스트")
    void 수동_로또_수량_빈값_테스트() {
        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndManualCount("1000", ""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> lottoGenerator.setPurchasePriceAndManualCount("1000", "로또"))
                .isInstanceOf(IllegalArgumentException.class);

        lottoGenerator.setPurchasePriceAndManualCount("2000", "0");
        assertThat(lottoGenerator.getManualCount()).isEqualTo(0);

        lottoGenerator.setPurchasePriceAndManualCount("2000", "2");
        assertThat(lottoGenerator.getManualCount()).isEqualTo(2);
    }
}
