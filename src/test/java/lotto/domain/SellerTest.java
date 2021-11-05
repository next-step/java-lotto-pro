package lotto.domain;

import lotto.exception.InputDataException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SellerTest {

    @Test
    @DisplayName("판매원에게 돈을 주면 로또로 교환해주는 테스트(만원을 주면 로또 10개를 살수 있다.)")
    void returnLotto() {
        int money = 10000;
        assertThat(Seller.returnLotto(money)).isEqualTo(10);
    }

    @Test
    @DisplayName("판매원에게 1000원 미만인 돈을 주었을 경우 테스트")
    void lessThanOneThoundreturnLotto() {
        int money = 100;
        assertThatExceptionOfType(InputDataException.class)
                .isThrownBy(() -> {
                        Seller.returnLotto(money);
                }).withMessageContaining("[ERROR]최소 로또 금액(1000원)보다 작게 입력하였습니다.");
    }
}
