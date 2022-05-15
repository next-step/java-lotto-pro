package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void 생성자_파라미터가_숫자가_아닌_문자열일_경우_예외가_발생한다() {
        // when and then
        assertThatThrownBy(() ->
            Money.of("30aa")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 넘어온_머니보다_작은지_확인한다() {
        // given
        Money money = Money.of(200);
        Money compare = Money.of(1000);
        // when
        boolean result = money.isLessThan(compare);
        // then
        assertThat(result).isTrue();
    }

    @Test
    void 나누기() {
        // given
        Money money = Money.of(5000);
        Money divide = Money.of(1000);
        // when
        int result = money.divide(divide);
        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 나누기를_해서_두자리_소수점을_반환한다() {
        // given
        Money money = Money.of(5000);
        Money divide = Money.of(14000);
        // when
        double result = money.divideDecimal(divide);
        // then
        assertThat(result).isEqualTo(0.35);
    }

    @Test
    void 곱하기() {
        // given
        Money money = Money.of(5000);
        // when
        Money result = money.multiply(10);
        // then
        assertThat(result).isEqualTo(Money.of(50000));
    }

    @Test
    void 더하기() {
        // given
        Money money = Money.of(5000);
        // when
        Money result = money.plus(Money.of(10000));
        // then
        assertThat(result).isEqualTo(Money.of(15000));
    }

}