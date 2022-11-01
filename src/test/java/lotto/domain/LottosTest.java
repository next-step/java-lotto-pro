package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottosTest {

    @Test
    @DisplayName("로또 구매 개수")
    void purchase_lotto_cnt_test() {
        assertThat(new Lottos(new Payment("14000")).getLottosSize()).isEqualTo(14);
    }

    @Test
    @DisplayName("구입금액에 1000원 미만인 경우 예외처리")
    void payment_less_than_1000_test() {
        assertThatThrownBy(() -> new Lottos(new Payment("400")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
