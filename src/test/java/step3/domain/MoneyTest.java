package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("실제 로또를 구입하는데 투자된 금액을 계산한다.")
    @Test
    void 투자금액_계산() {
        assertThat(Money.investmentAmount(4, 1)).isEqualTo(5_000);
    }

    @DisplayName("입력된 금액으로 구매가능한 로또 개수를 반환한다.")
    @Test
    void 구매가능한_로또_개수() {
        Money money = new Money(5_000);
        assertThat(money.lottoCount()).isEqualTo(5);
    }
}