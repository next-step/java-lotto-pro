package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosCountTest {

    @DisplayName("총 로또 갯수 객체 생성")
    @Test
    void lottosCount() {
        LottosCount lottosCount = new LottosCount(10, 9);
        assertThat(lottosCount.auto()).isEqualTo(1);
        assertThat(lottosCount.getTotal()).isEqualTo(10);
        assertThat(lottosCount.getManual()).isEqualTo(9);
    }

    @DisplayName("수동으로 구매할 로또 수가 구매가능한 로또수 보다 클때 에러 검증")
    @Test
    void buyManualLottoOverError() {
        assertThatThrownBy(() -> {
            new LottosCount(9, 10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_OF_MONEY);
    }
}
