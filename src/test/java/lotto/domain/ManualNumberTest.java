package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManualNumberTest {

    @DisplayName("수동 구매 개수를 입력하면 객체가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void createManualNumber(int manual) {
        assertThat(new ManualNumber(manual)).isNotNull();
    }

    @DisplayName("0보다 작은 수를 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void throwRangeErrorByManual(int manual) {
        assertThatThrownBy(() -> new ManualNumber(manual)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 가능한 개수보다 큰 수를 입력할 경우 오류가 발생한다.")
    void throwRangeErrorByMoney() {
        Money money = new Money(5000);
        assertAll(
            () -> assertThatThrownBy(() -> new ManualNumber(6, money)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new ManualNumber(7, money)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("지불한 금액 내 구매 가능한 개수를 입력할 경우 객체가 생성된다.")
    void createManualNumberWithMoney() {
        Money money = new Money(5000);
        assertAll(
            () -> assertThat(new ManualNumber(0, money)).isNotNull(),
            () -> assertThat(new ManualNumber(1, money)).isNotNull(),
            () -> assertThat(new ManualNumber(5, money)).isNotNull()
        );
    }
}