package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lottos;

class LottoMachineTest {
    private static final BigDecimal LOTTO_PRICE = new BigDecimal(1000);

    private LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        LottoPrice lottoPrice = new LottoPrice(LOTTO_PRICE);
        lottoMachine = new LottoMachine(new AutomaticLottoGenerator(), lottoPrice);
    }

    @Test
    @DisplayName("1000원으로 1장을 발급한다.")
    void 로또_1장_발급() {
        Lottos lottos = lottoMachine.issueLotto(new BigDecimal(1000)).getLottos();
        assertThat(lottos.getLottoList()).hasSize(1);
    }

    @Test
    @DisplayName("1장에 1000원씩 돈이 가능한만큼 발급한다.")
    void 로또_5장_발급() {
        Lottos lottos = lottoMachine.issueLotto(new BigDecimal(5500)).getLottos();
        assertThat(lottos.getLottoList()).hasSize(5);
    }

    @Test
    @DisplayName("돈이 부족하면 IllegalArgumentException 를 발생시킨다.")
    void 로또금액_부족() {
        assertThatThrownBy(() -> lottoMachine.issueLotto(new BigDecimal(900))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 null이면 IllegalArgumentException 를 발생시킨다.")
    void 로또금액_null() {
        assertThatThrownBy(() -> lottoMachine.issueLotto(null)).isInstanceOf(IllegalArgumentException.class);
    }
}
