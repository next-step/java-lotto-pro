package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("Money를 생성한다.")
    @Test
    void 금액_생성() {
        Money actual = new Money(1000);
        assertThat(actual).isEqualTo(new Money(1000));
    }

    @DisplayName("Money는 0이상이어야 한다.")
    @Test
    void invalid_금액_생성() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 금액으로 구매가능한 로또 개수를 반환한다.")
    @Test
    void 구매가능한_로또_개수() {
        Money money = new Money(5_000);
        assertThat(money.lottoCount(Lotto.PRICE_LOTTO)).isEqualTo(5);
    }

}