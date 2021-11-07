package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.LottoNumber.GAME_PRICE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("입력 금액 생성 테스트")
    public void money() {
        Money money = new Money(1000);

        Money expected = new Money(1000);

        Assertions.assertThat(money).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력 금액 테스트(0원)")
    public void money2() {
        assertThatThrownBy(() -> {
            new Money(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("구매 회수 테스트")
    public void money3() {
        Money money = new Money(1000);

        int purchaseCount = money.getPurchaseCount(GAME_PRICE);

        Assertions.assertThat(purchaseCount).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 금액 나머지 존재")
    public void money4() {
        assertThatThrownBy(() -> {
            new Money(1550);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}