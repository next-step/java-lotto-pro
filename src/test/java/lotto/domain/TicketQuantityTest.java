package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TicketQuantityTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("수량 입력 값이 null 이거나 비어있을 경우 Exception 발생 확인")
    void validateNullOrEmpty(String input) {
        assertThatThrownBy(() -> {
            new TicketQuantity(input, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "%"})
    @DisplayName("숫자 이외 값 입력받을 경우 Exception 발생 확인")
    void validateNumber(String quantity) {
        assertThatThrownBy(() -> {
            new TicketQuantity(quantity, 0);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:1", "2:1"}, delimiter = ':')
    @DisplayName("0개 미만 또는 최대 수량 초과하여 생성하는 경우 Exception 발생 확인")
    void validateRange(String quantity, int maxQuantity) {
        assertThatThrownBy(() -> {
            new TicketQuantity(quantity, maxQuantity);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
