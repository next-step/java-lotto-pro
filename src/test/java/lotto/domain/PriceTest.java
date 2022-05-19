package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("금액 테스트")
class PriceTest {

    @DisplayName("금액을 생성자로 전달하면 동일하게 반환된다")
    @Test
    void price_test() {
        Price price = new Price(14000);
        assertThat(price.getPrice()).isEqualTo(14000);
    }

    @DisplayName("금액을 사용하면 잔액이 반환되어야 한다")
    @Test
    void price_test2() {
        int 지불금액 = 14000;
        int 수동금액 = 5000;
        int 잔액 = 지불금액 - 수동금액;

        Price price = new Price(지불금액);
        price.spend(수동금액);
        assertThat(price.getPrice()).isEqualTo(잔액);
    }
}
