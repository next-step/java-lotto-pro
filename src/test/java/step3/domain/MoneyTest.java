package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {

    @ParameterizedTest
    @CsvSource(value = {"1000:false", "999:false", "a:true", "19991:false"}, delimiter = ':')
    public void createMoneyTest(String money, boolean isException) {
        if (isException) {
            assertThatThrownBy(() -> new Money(money)).isInstanceOf(IllegalArgumentException.class);
        } else {
            assertDoesNotThrow(() -> new Money(money));
        }
    }




}
