package step3.lotto.domain.customer.wrap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;
import static step3.lotto.domain.customer.wrap.ManualAttemptsCount.INVALID_MANUAL_ATTEMPTS_COUNT_RANGE_ERROR;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/22 4:31 오후
 */
@DisplayName("Domain:ManualAttemptsCount")
public class ManualAttemptsCountTest {

    @Test
    @DisplayName("수동 로또 횟수 객체 생성 검증")
    public void createManualAttemptsCount() {
        // Given
        final Price price = Price.of(15000);
        final int manualAttemptsCount = 5;

        // When
        ManualAttemptsCount actual = ManualAttemptsCount.of(manualAttemptsCount, price);

        // Then
        assertAll(
            () -> assertThat(actual).isNotNull(),
            () -> assertThat(actual).isEqualTo(ManualAttemptsCount.of(manualAttemptsCount, price))
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("유효하지 못한 수동 로또 구매 횟수 입력 시 예외 검증")
    public void throwException_WhenInvalidManualAttemptsCount(
        final int manualAttemptsCount,
        final Price price,
        final String givenDescription
    ) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> ManualAttemptsCount.of(manualAttemptsCount, price))
            .as(givenDescription)
            .withMessageMatching(INVALID_MANUAL_ATTEMPTS_COUNT_RANGE_ERROR);
    }

    private static Stream throwException_WhenInvalidManualAttemptsCount() {
        final Price price = Price.of(15000);
        return Stream.of(
            Arguments.of(-1, price, "수동 로또 구매 횟수가 음수인 경우"),
            Arguments.of(price.calculateAttemptsCount() + 1, price, "수동 로또 구매 횟수가 구매 금액을 벗어나는 경우")
        );
    }
}
