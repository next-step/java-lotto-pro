package step3.lotto.domain.customer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:04 오후
 */
@DisplayName("Domain:Customer")
class CustomerTest {

    @Test
    @DisplayName("사용자 도메인 생성 여부 검증")
    public void createCustomerTest() {
        // Given
        final int given = 1_000;

        // When
        Customer actual = new Customer(given);

        // Then
        assertThat(actual.getTryCount()).isEqualTo(1);
    }
}
