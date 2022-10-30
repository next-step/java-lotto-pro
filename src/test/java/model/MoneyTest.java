package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void 천원이하의_금액을_입력하면_오류를_리턴한다() {
        int money = 100;
        assertThatThrownBy(() -> {
            new Money(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력해주세요.");
    }

    @Test
    void 구매가능한_로또_갯수를_리턴한다() {
        int money = 10000;

        int availableBuyCount = new Money(money).availableBuyLottoCount();

        Assertions.assertThat(availableBuyCount).isEqualTo(10);
    }
}