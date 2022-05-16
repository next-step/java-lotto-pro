package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", " 1000", "1000 ", " 1000 "})
    @DisplayName("주어진 문자열로 Money가 생성되어야 한다 (trim이 필요한 문자여도 정상적으로 생성되어야 한다)")
    void create_success_with_money(String string) {
        Money money = new Money(string);

        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @Test
    @DisplayName("주어진 문자열이 비어있는 경우 오류가 발생되어야 한다")
    void create_fail_with_empty_money() {
        String string = "";

        assertThatThrownBy(() -> {
            Money money = new Money(string);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("주어진 문자열이 숫자가 아닌 경우 오류가 발생되야 한다")
    void create_fail_with_non_number_money() {
        String string = "가";

        assertThatThrownBy(() -> {
            Money money = new Money(string);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("주어진 문자열이 음수인 경우 오류가 발생되어야 한다")
    void create_fail_with_negative_number() {
        String string = "-1";

        assertThatThrownBy(() -> {
            Money money = new Money(string);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("주어진 문자열 내 금액이 1000원 미만일 경우 오류가 발생되어야 한다")
    void create_fail_with_under_1000_number() {
        String string = "999";

        assertThatThrownBy(() -> {
            Money money = new Money(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("주어진 문자열 내 금액이 1000원의 배수가 아닐 경우 오류가 발생되어야 한다")
    void create_fail_with_times_of_1000() {
        String string = "2500";

        assertThatThrownBy(() -> {
            Money money = new Money(string);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("calculateLottoTicketCount 메소드는 구매가능한 LottoTicket의 개수를 반환해야 한다")
    void returns_available_ticket_count() {
        String string = "12000";
        Money money = new Money(string);
        assertThat(money.calculateLottoTicketCount()).isEqualTo(12);
    }
}
