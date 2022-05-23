package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {
    private final LottoMachine lottoMachine;

    LottoMachineTest() {
        this.lottoMachine = LottoMachine.getInstance();
    }

    @Test
    @DisplayName("로또 금액 부족 오류 테스트")
    void lotto_lack_money_test() {
        assertThatThrownBy(() -> lottoMachine.purchase(500L))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 맞는 로또 갯수 구입 테스트")
    void lotto_buy_test() {
        lottoMachine.purchase(5000L);
        assertThat(lottoMachine.purchase(5000L)).isEqualTo(5);
    }

    @Test
    @DisplayName("자동 복권 구입 테스트")
    void auto_lotto_test() {
        int buyCount = lottoMachine.purchase(5000L);
        List<Lotto> lottoes = lottoMachine.generateAutos(buyCount);

        assertThat(lottoes).hasSize(5);
        assertThat(lottoes.get(0)).isExactlyInstanceOf(Lotto.class);
    }

}