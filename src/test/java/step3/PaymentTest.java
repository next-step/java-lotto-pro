package step3;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.domain.Payment;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTest {
    @Test
    @DisplayName("구입금액 생성")
    public void Payment_Create() {
        Payment payment = new Payment(10000);
        assertThat(payment.getPayment()).isEqualTo(10000);
    }
    
    @Test
    @DisplayName("구입금액 음수인 경우 0으로 처리")
    public void Payment_Negative() {
        Payment payment = new Payment(-1000);
        assertThat(payment.getPayment()).isEqualTo(0);
    }
    
    @Test
    public void payment_lotto_count() {
        Payment payment = new Payment(1000);
        assertThat(payment.getLottoCount()).isEqualTo(1);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"0:0","999:0","2999:2","-1000:0"}, delimiter = ':')
    @DisplayName("변수와 예상값 입력하여 검증")
    void calculator_lotto_count_exception(Integer input, int expected) {
        Payment payment = new Payment(input);
        AssertionsForClassTypes.assertThat(payment.getLottoCount()).isEqualTo(expected);
    }
}
