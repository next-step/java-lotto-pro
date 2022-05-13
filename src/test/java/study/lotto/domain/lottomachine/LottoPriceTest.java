package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPriceTest {
    private final LottoPrice lottoPrice = new LottoPrice();

    @Test
    @DisplayName("기본 로또 금액은 1000원이다.")
    void 로또의_금액은_1000원() {
        assertThat(lottoPrice).isEqualTo(new LottoPrice(new BigDecimal(1000)));
    }

    @Test
    @DisplayName("입력받은 금액으로 발행가능한 최대 로또 수를 구한다.")
    void 입력받은_금액으로_발행_가능한_최대_개수() {
        assertThat(lottoPrice.maximumIssuableCount(new BigDecimal(5500))).isEqualTo(5);
    }

    @Test
    @DisplayName("발행한 로또 가격 합을 구한다.")
    void 발행한_로또_가격() {
        assertThat(lottoPrice.total(5)).isEqualTo(new BigDecimal(5000));
    }
}
