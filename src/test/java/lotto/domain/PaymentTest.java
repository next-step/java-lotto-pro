package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @ParameterizedTest
    @ValueSource(longs = {-1000, 0, 999})
    void validate_로또_가격_1000원_미만(Long pay) {
        assertThatThrownBy(() -> Payment.from(pay, 1)).isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("The price of a lottery ticket is 1,000 won.");
    }

    @ParameterizedTest
    @CsvSource(value = {"1500:1", "14000:14"}, delimiter = ':')
    void calculate_구입금액_로또_장수_계산(Long pay, int count) {
        int cnt = Payment.from(pay, 1).getPurchaseCount();
        assertThat(cnt).isEqualTo(count);
    }

    @Test
    void from_manualLotto_구입금액_수동로또_계산() {
        Payment payment = Payment.from(5000L, 1);
        assertThat(payment.matchManualLottoPurchaseCount(1)).isTrue();
    }

    @Test
    void validate_예외_한글입력() {
        assertThatThrownBy(()-> Payment.from("a", "1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Only numbers can be entered.");
    }

    @Test
    void validate_예외_1000원_이하입력() {
        assertThatThrownBy(()-> Payment.from("999", "1")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The price of a lottery ticket is 1,000 won.");
    }
}
