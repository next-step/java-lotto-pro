package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("입력_값이_0이상인_경우_확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{arguments}]")
    @ValueSource(ints = {0, 1000, 10000})
    void 입력_값이_0이상인_경우_확인(int testValue) {
        // when, then
        assertThat(new Money(testValue)).isEqualTo(new Money(testValue));
    }

    @Test
    @DisplayName("입력 값이 음수인 경우 확인")
    void 입력_값이_음수인_경우_확인() {
        // when, then
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Money.PRICE_IS_MINUS_ERROR_MESSAGE);
    }

    @DisplayName("구입한 로또 갯수 확인")
    @ParameterizedTest(name = "{displayName} ({index}) -> param = [{arguments}]")
    @CsvSource(value = {"14500:14", "1300:1", "9800:9"}, delimiter = ':')
    void 구입한_로또_갯수_확인(int testValue, int expectedResult) {
        // given
        Money money = new Money(testValue);

        // when
        LottoBundle lottoBundle = money.buyAllRandomLotto();

        //then
        assertThat(lottoBundle.getLottoCount())
                .isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("수동 로또 구입 가능 여부 확인 - 성공")
    void 수동_로또_구입_가능_여부_확인_성공() {
        // given
        Money money = new Money(10000);

        // when
        boolean ableToBuyCustomLotto = money.isAbleToBuyCustomLotto(10);

        // when, then
        assertThat(ableToBuyCustomLotto)
                .isTrue();
    }

    @Test
    @DisplayName("수동 로또 구입 가능 여부 확인 - 실패")
    void 수동_로또_구입_가능_여부_확인_실패() {
        // given
        Money money = new Money(10000);

        // when
        boolean ableToBuyCustomLotto = money.isAbleToBuyCustomLotto(11);

        // when, then
        assertThat(ableToBuyCustomLotto)
                .isFalse();
    }
}
