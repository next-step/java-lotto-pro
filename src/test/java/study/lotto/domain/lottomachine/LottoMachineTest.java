package study.lotto.domain.lottomachine;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.AutomaticLottoGenerator;
import study.lotto.domain.Lotto;
import study.lotto.domain.lottomachine.LottoMachine;
import study.lotto.domain.lottomachine.LottoPrice;

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
        List<Lotto> lottoList = lottoMachine.issueLotto(new BigDecimal(1000));
        assertThat(lottoList).hasSize(1);
    }

    @Test
    @DisplayName("1장에 1000원씩 돈이 가능한만큼 발급한다.")
    void 로또_5장_발급() {
        assertThat(lottoMachine.issueLotto(new BigDecimal(5500))).hasSize(5);
    }

    @Test
    @DisplayName("돈이 부족하면 0개의 로또를 발급한다.")
    void 로또금액_부족() {
        assertThat(lottoMachine.issueLotto(new BigDecimal(900))).isEmpty();
    }

    @Test
    @DisplayName("금액이 null이면 0개의 로또를 발급한다.")
    void 로또금액_null() {
        assertThat(lottoMachine.issueLotto(null)).isEmpty();
    }
}
