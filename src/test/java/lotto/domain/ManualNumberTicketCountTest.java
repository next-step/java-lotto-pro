package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class ManualNumberTicketCountTest {

    @DisplayName("수동 구매 개수를 입력하면 객체가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void createManualNumber(int manualTicketCount) {
        assertThat(new ManualLottoTicketCount(manualTicketCount)).isNotNull();
    }

    @DisplayName("0보다 작은 수를 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3})
    void throwRangeErrorByManual(int manualTicketCount) {
        assertThatThrownBy(() -> new ManualLottoTicketCount(manualTicketCount)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 가능한 개수보다 큰 수를 입력할 경우 오류가 발생한다.")
    void throwRangeErrorByMoney() {
        Money money = new Money(5000);
        assertAll(
            () -> assertThatThrownBy(() -> new ManualLottoTicketCount(6, money)).isInstanceOf(IllegalArgumentException.class),
            () -> assertThatThrownBy(() -> new ManualLottoTicketCount(7, money)).isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("지불한 금액 내 구매 가능한 개수를 입력할 경우 객체가 생성된다.")
    void createManualNumberWithMoney() {
        Money money = new Money(5000);
        assertAll(
            () -> assertThat(new ManualLottoTicketCount(0, money)).isNotNull(),
            () -> assertThat(new ManualLottoTicketCount(1, money)).isNotNull(),
            () -> assertThat(new ManualLottoTicketCount(5, money)).isNotNull()
        );
    }
}