package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    @DisplayName("1000원 짜리 화폐 생성")
    void create() {
        assertThat(Money.of(10000)).isEqualTo(Money.of("10000"));
    }

    @Test
    @DisplayName("화폐의 생성자는 텍스트가 올 수 없다")
    void parseLong() {
        assertThatThrownBy(() -> {
            Money.of("천 원");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("2000원짜리 화폐는 1000원짜리 화폐보다 크거나 같다")
    void greaterEqualThan() {
        Money source = Money.of(2000);
        Money target = Money.of(1000);
        assertTrue(source.greaterEqualThan(target));
    }

    @Test
    @DisplayName("2000원짜리 화폐 나누기 1000원짜리 화폐는 몫이 2이다")
    void quotient() {
        Money source = Money.of(2000);
        Money target = Money.of(1000);
        assertThat(source.quotient(target)).isEqualTo(2);
    }

    @Test
    @DisplayName("2000원짜리 화폐 더하기 1000원짜리 화폐는 3000원이다.")
    void sum() {
        Money source = Money.of(2000);
        Money target = Money.of(1000);
        assertThat(source.sum(target)).isEqualTo(Money.of(3000));
    }

    @Test
    @DisplayName("14000원짜리 화폐 나누기(소수점 포함) 5000원짜리 화폐를 나누면 0.35이다")
    void divide() {
        Money source = Money.of(5000);
        Money target = Money.of(14000);
        assertThat(source.divide(target)).isEqualTo(0.35);
    }

}
