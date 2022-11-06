package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

@DisplayName("금액 클래스 테스트")
class MoneyTest {

    @DisplayName("생성 성공")
    @Test
    void create_new_throwNoException() {
        //given:
        int amount = 1000;
        //when, then:
        assertThatNoException().isThrownBy(() -> Money.from(amount));
    }

    @DisplayName("정적 팩토리 메서드 생성자 테스트")
    @Test
    void of_money_success() {
        assertThatNoException().isThrownBy(() -> Money.from(0));
    }

    @ParameterizedTest(name = "나누기 메서드 테스트" + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "150:15", "155:15" }, delimiter = ':')
    void divide_money_success(long amount, long operandMoney) {
        //given:
        long result = 10;
        assertThat(Money.from(amount).divide(Money.from(operandMoney))).isEqualTo(result);
    }
}
