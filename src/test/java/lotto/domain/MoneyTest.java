package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    
    @Test
    @DisplayName("돈이 입력됐는지 확인")
    void 돈_입력() {
        Money money = new Money(500000);
        assertThat(money.getMoney()).isEqualTo(500000);
    }
}
