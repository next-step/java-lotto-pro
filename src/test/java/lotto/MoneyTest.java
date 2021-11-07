package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @DisplayName("구입금액에 따른 로또 개수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "3600:3"}, delimiter = ':')
    void lottoCountTest(String input, int expected) {
        Money money = new Money(input);
        assertThat(money.getLottoCount()).isEqualTo(expected);
    }

    @DisplayName("최소 구입금액보다 작은 금액을 입력할 경우 예외 발생테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "500"})
    public void minimumAmountTest(String input) throws Exception {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 문자를 입력할 경우 예외 발생테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asdfs", "[[]]]"})
    public void textTest(String input) throws Exception {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
