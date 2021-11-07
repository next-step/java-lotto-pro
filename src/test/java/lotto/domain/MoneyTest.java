package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(new Money(1000).getPurchaseCount()).isEqualTo(1);
    }

}