package study.step3;

import domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    private Money money;

    @Test
    @DisplayName("입력받은 숫자를 횟수로 반환")
    void 금액을_횟수로_반환() {
        money = new Money(14000);
        int expectValue = 14;

        int result = money.countOfLottoTicket();

        assertThat(result).isEqualTo(expectValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("입력받은 금액이 0원 이하일 경우 Exception 발생")
    void 금액_유효성_음수_체크(int given) {
        assertThatThrownBy(() ->
                new Money(given)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("티켓 구매 가격은 0원 이하가 될 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1155, 1999})
    @DisplayName("입력받은 금액이 천원단위가 아닐 경우 Exception 발생")
    void 금액_유효성_천원단위_체크(int given) {
        assertThatThrownBy(() ->
                new Money(given)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("티켓 구매 가격은 천원단위로 가능 합니다.");
    }

}
