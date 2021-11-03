package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @DisplayName("지불금액이 1000원 미만이면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-500, 0, 999})
    void validate(int payment) {
        assertThatThrownBy(() -> Payment.from(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지불금액에 따른 구입 가능한 횟수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5900,5", "1200,1", "10000,10"})
    void getTryCount(int payment, int tryCount) {
        assertThat(Payment.from(payment).getTryCount()).isEqualTo(tryCount);
    }

}
