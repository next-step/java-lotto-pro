package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Payment;

public class PaymentTest {
    @Test
    @DisplayName("구입금액 생성")
    public void payment_Create() {
        Payment payment = new Payment(10000, 0);
        assertThat(payment.getPayment()).isEqualTo(10000);
    }

    @Test
    @DisplayName("구입금액 음수인 경우 예외처리")
    public void payment_Negative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Payment(-1000, 0));
    }
    
    @Test
    public void payment_lotto_count() {
        Payment payment = new Payment(1000, 0);
        assertThat(payment.getLottoCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "999:0", "2999:2"}, delimiter = ':')
    @DisplayName("변수와 예상값 입력하여 검증")
    void calculator_lotto_count_exception(Integer input, int expected) {
        Payment payment = new Payment(input, 0);
        AssertionsForClassTypes.assertThat(payment.getLottoCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수동 개수 입력기능 추가")
    public void payment_manual_count() {
        Payment payment = new Payment(10000, 3);
        assertThat(payment.getManualLottoCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동 개수 입력 예외처리")
    public void payment_manual_count_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Payment(10000, -1));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Payment(10000, 11));
    }

    @Test
    @DisplayName("수동 개수에 따른 자동개수 계산")
    public void payment_auto_count() {
        Payment payment = new Payment(10000, 3);
        assertThat(payment.getAutoLottoCount()).isEqualTo(7);
    }
}
