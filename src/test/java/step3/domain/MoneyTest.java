package step3.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyTest {
    @DisplayName("Money는 0이상이어야 한다.")
    @Test
    void 금액_생성() {
        Money actual = new Money(1000);
        assertThat(actual).isEqualTo(new Money(1000));
    }

    @DisplayName("Money는 0이상이어야 한다.")
    @Test
    void invalid_금액_생성() {
        assertThatThrownBy(() -> {
            new Money(-10000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실제 로또를 구입하는데 투자된 금액을 계산한다.")
    @Test
    void 투자금액_계산() {
        assertThat(Money.investmentAmount(new LottoCount(4), new LottoCount(1))).isEqualTo(5_000);
    }

    @DisplayName("입력된 금액으로 구매가능한 로또 개수를 반환한다.")
    @Test
    void 구매가능한_로또_개수() {
        Money money = new Money(5_000);
        assertThat(money.lottoCount()).isEqualTo(5);
    }

    @ParameterizedTest(name = "입력된 금액에 따른 구입가능한 자동로또 개수를 반환한다. ({0} : {1})")
    @CsvSource(value = {"2000:1", "5000:4", "100:0"}, delimiter = ':')
    void 구입가능한_자동로또_개수_반환(int money, int expected) {
        Money actual = new Money(money);
        assertThat(actual.autoLottoCount(new LottoCount(1)).get()).isEqualTo(expected);
    }
}