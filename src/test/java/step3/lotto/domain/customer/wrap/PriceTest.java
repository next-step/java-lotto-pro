package step3.lotto.domain.customer.wrap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step3.lotto.domain.customer.wrap.Price.HAS_CHANGES_ERROR;
import static step3.lotto.domain.customer.wrap.Price.MINIMUM_LOTTO_PRICE;
import static step3.lotto.domain.customer.wrap.Price.MINIMUM_LOTTO_PRICE_ERROR;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : choi-ys
 * @date : 2022/05/17 2:04 오후
 */
@DisplayName("Domain:Wrap:Price")
class PriceTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 999})
    @DisplayName("1000원 이하의 유효하지 못한 금액 입력 시 예외")
    public void throwException_WhenInvalidPrice(final int given) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Price.of(given))
            .withMessageMatching(MINIMUM_LOTTO_PRICE_ERROR);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 1999})
    @DisplayName("1000원 단위가 아닌 잔돈이 발생하는 금액 입력 시 예외")
    public void throwException_WhenPriceHasChanges(final int given) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Price.of(given))
            .withMessageMatching(HAS_CHANGES_ERROR);
    }

    @Test
    @DisplayName("입력한 금액에 해당하는 로또 횟수 반환 검증")
    public void returnTryCount_GivenPrice() {
        // Given
        final int given = 15000;
        final int expected = given / MINIMUM_LOTTO_PRICE;

        // When & Then
        assertThat(Price.of(given).calculateTryCount()).isEqualTo(expected);
    }
}

