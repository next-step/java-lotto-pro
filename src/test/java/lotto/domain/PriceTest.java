package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 구매금액이 로또 금액보다 낮으면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 150, 300, 800, -2500})
    void price_test3(int 금액) {
        assertThatThrownBy(() -> {
            new Price(금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
    }

    @DisplayName("로또 구매금액이 로또 금액단위가 아니면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {3500, 2222, 125400, 5050})
    void price_test4(int 금액) {
        assertThatThrownBy(() -> {
            new Price(금액);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
    }
}
