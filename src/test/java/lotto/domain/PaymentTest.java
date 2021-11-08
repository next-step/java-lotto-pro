package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 999})
    void validate_로또_가격_1000원_미만(int pay) {
        assertThatThrownBy(() -> Payment.from(pay)).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("The price of a lottery ticket is 1,000 won.");
    }

    @CsvSource(value = {"1500:1", "14000:14"}, delimiter = ':')
    void calculate_구입금액_로또_장수_계산(int pay, int count) {
        int cnt = Payment.from(pay).getPurchaseCount();
        assertThat(cnt).isEqualTo(count);
    }
}
