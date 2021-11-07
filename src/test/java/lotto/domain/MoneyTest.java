package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static lotto.domain.LottoNumber.GAME_PRICE;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("입력 금액 생성 테스트")
    public void money() {
        Money money = new Money(BigDecimal.valueOf(1000));

        Money expected = new Money(BigDecimal.valueOf(1000));

        assertThat(money).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력 금액 테스트(0원)")
    public void money2() {
        Money money = new Money(BigDecimal.valueOf(0));
        LottoMachine machine = new LottoMachine(money);

        int count = machine.getLottoList().size();

        assertThat(count).isEqualTo(0);
    }

    @Test
    @DisplayName("구매 회수 테스트")
    public void money3() {
        Money money = new Money(BigDecimal.valueOf(1000));
        LottoMachine machine = new LottoMachine(money);

        int purchaseCount = machine.getLottoList().size();

        assertThat(purchaseCount).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 금액 나머지 존재")
    public void money4() {
        assertThatThrownBy(() -> {
            Money money = new Money(BigDecimal.valueOf(1500));

            LottoMachine machine = new LottoMachine(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

}