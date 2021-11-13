package lotto.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RateOfReturnTest {
    @Test
    @DisplayName("음수가 들어올 경우 예외 발생")
    void 객체_생성_시_유효성_검사() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new RateOfReturn(-0.1));
    }

    @Test
    @DisplayName("1 미만의 값을 가지면 isLosingMoney()는 true를 반환, 1 이상의 값을 가지면 false를 반환하는지 테스트")
    void isLosingMoney() {
        RateOfReturn notLosingMoneyRate = new RateOfReturn(1);
        assertThat(notLosingMoneyRate.isLosingMoney()).isFalse();

        RateOfReturn losingMoneyRate = new RateOfReturn(0.99);
        assertThat(losingMoneyRate.isLosingMoney()).isTrue();
    }

    @Test
    @DisplayName("동등성 검사")
    void equals() {
        RateOfReturn expected = new RateOfReturn(1.1);
        RateOfReturn actual = new RateOfReturn(1.1);
        assertThat(actual).isEqualTo(expected);
    }
}
