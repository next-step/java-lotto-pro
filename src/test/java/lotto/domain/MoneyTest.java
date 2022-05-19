package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {
    @Test
    @DisplayName("구매금액 3500원으로 구매가능한 수량은 3이다")
    void purchasableQuantity() {
        assertThat(new Money(3500).getQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("구입금액이 1000원 이하로 입력되면 예외가 발생한다")
    void lessThen_1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(999)).withMessage("금액이 부족합니다.(최소필요금액: 1000)");
    }

    @Test
    @DisplayName("구입금액이 로또 최소금액 1000원 미만이면 true 를 반환한다")
    void lessThenLottoPriceTrue() {
        assertThat(new Money(999).lessThenLottoPrice()).isTrue();
    }

    @Test
    @DisplayName("구입금액이 로또 최소금액 1000원 이상이면 false 를 반환한다")
    void lessThenLottoPriceFalse() {
        assertThat(new Money(1000).lessThenLottoPrice()).isFalse();
    }

    @Test
    @DisplayName("5000원에 5000원을 더하면 10000원을 가진 Money 객체를 반환한다")
    void sumMoney() {
        assertThat(new Money(5000).sumMoney(new Money(5000))).isEqualTo(new Money(10000));
    }

    @Test
    @DisplayName("구입금액5000, 당첨금액 5000을 입력하면 수익률은 1이다")
    void calculateRateOfReturn() {
        assertThat(new Money(5000).calculateRateOfReturn(new Money(5000))).isEqualTo(1);
    }

    @Test
    @DisplayName("멤버변수 값이 5000이면 문자열 ₩ 5000을 반환한다")
    void krw() {
        assertThat(new Money(5000).krw()).isEqualTo("₩ 5,000");
    }
}
