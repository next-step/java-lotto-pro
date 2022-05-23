package lotto.domain;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("마이너스 금액 Exception 테스트")
    void minus_money_test() {
       assertThatThrownBy(() -> new Money(-1000L))
               .isInstanceOf(LottoException.class);
    }
}