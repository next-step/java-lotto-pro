package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseTest {

    @Test
    void 구입금액을_생성한다() {
        assertThat(new Purchase(1000)).isEqualTo(new Purchase(1000));
    }

    @Test
    void 구입금액이_음수인_경우_에러를_발생시킨다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Purchase(-1000));
    }

    @ParameterizedTest(name = "{0}원 구입 시, {1}개의 로또 구매")
    @CsvSource(value = {"14000,14","500,0","1000,1","0,0"})
    void 생성가능한_로또_개수를_반환한다(int price, int expected) {
        Purchase purchase = new Purchase(price);
        assertThat(purchase.buy()).isEqualTo(expected);
    }
}