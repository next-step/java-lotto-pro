package lotto.model.money;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("입력된 금액이 0보다 작을 경우 예외처리")
    void 입력된_금액이_0원보다_작을_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(-1));
    }

    @Test
    @DisplayName("지불한 금액 대비 구입 가능한 로또의 개수를 출력")
    void 구입_가능한_로또_개수_출력() {
        Money money = new Money(14_500);
        assertEquals(money.possiblePurchaseLotto(), 14);
    }

}
