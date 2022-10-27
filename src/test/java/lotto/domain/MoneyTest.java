package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {


    @DisplayName("1000원 이상의 수를 입력하면 Money 를 생성할 수 있다.")
    @Test
    void money() {

    }

    @DisplayName("1000원 이하의 수가 입력되면 IllegalArgumentException 이 발생한다.")
    @Test
    void money_fail() {

    }

    @DisplayName("입력한 금액 / 1000 개의 로또를 구매할 수 있다.")
    @Test
    void money_count() {

    }
}
