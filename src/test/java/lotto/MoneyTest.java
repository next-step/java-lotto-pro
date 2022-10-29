package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

class MoneyTest {

    @DisplayName("Money 생성 성공")
    @Test
    void create_new_throwNoException() {
        //given:
        int amount = 1000;
        //when, then:
        assertThatNoException().isThrownBy(() -> new Money(amount));
    }

    @ParameterizedTest(name = "minus 메서드 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "500:500", "2000:1000" }, delimiter = ':')
    void minus_amount_success(int minusAmount, int result) {
        // amount 값에 대한 getter를 생성하고 싶지 않은데 minus 결과물을 확인하려면 getter로 값을 검증해야한다
        // 이와 같은 상황에서 어떻게 해야할까..?
        //given:
        int amount = 1000;
        //when:
        Money money = new Money(amount);
        money.minus(minusAmount);
        //then:
        assertThat(money.getAmount()).isEqualTo(result);
    }

    @ParameterizedTest(name = "minus 메서드 테스트 " + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "500:true", "2000:false" }, delimiter = ':')
    void isEqualsOrGreater_amount_success(int operandAmount, boolean result) {
        //given:
        int amount = 1000;
        //when:
        Money money = new Money(amount);
        //then:
        assertThat(money.isEqualsOrGreater(operandAmount)).isEqualTo(result);
    }
}
