package lotto;

import lotto.model.LottoQuantityChecker;
import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoQuantityChecker는 ")
public class LottoQuantityCheckerTest {
    @DisplayName("금액에 따른 로또 수량을 계산한다")
    @Test
    void validCheck() {
        Money money = new Money("14000");
        assertThat(LottoQuantityChecker.calculate(money)).isEqualTo(14);
    }
}
